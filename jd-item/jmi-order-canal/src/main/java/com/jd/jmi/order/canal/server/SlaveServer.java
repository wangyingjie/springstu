package com.jd.jmi.order.canal.server;

import com.alibaba.otter.canal.deployer.CanalConstants;
import com.alibaba.otter.canal.deployer.CanalController;
import com.alibaba.otter.canal.deployer.CanalLauncher;
import com.jd.jmi.order.canal.common.utils.CanalZkStatusUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by changpan on 2015/9/25.
 */
public class SlaveServer {
    private static final Log logger = LogFactory.getLog(SlaveServer.class);

    private static final String CLASSPATH_URL_PREFIX = "classpath:";

    private CanalController controller;

    private List<String> configs;

    private String destinations;

    private String token = "";

    public void init(){
        logger.info("****************************** canal server init ***************************************\n");
        try{
            if(configs==null){
                configs = new ArrayList<String>();
                configs.add(System.getProperty("canal.conf", "classpath:canal.properties"));
            }
            Properties properties = new Properties();
            for(String conf:configs){
                if (conf.startsWith(CLASSPATH_URL_PREFIX)) {
                    conf = StringUtils.substringAfter(conf, CLASSPATH_URL_PREFIX);
                    properties.load(CanalLauncher.class.getClassLoader().getResourceAsStream(conf));
                } else {
                    InputStream is = null;
                    try {
                        is = new FileInputStream(conf);
                        properties.load(is);
                    } catch (Exception e) {
                        logger.info("## load property file failed! " + conf, e);
                    } finally {
                        if (is != null) {
                            is.close();
                        }
                    }
                }
            }
            if(!isBlank(destinations)){
                properties.setProperty(CanalConstants.CANAL_DESTINATIONS,destinations);
            }else if(isBlank(properties.getProperty(CanalConstants.CANAL_DESTINATIONS))){
                logger.error("****************************** canal des is blank ***************************************\n");
                return;
            }
            logger.info("destinations="+properties.getProperty(CanalConstants.CANAL_DESTINATIONS));
            if(isBlank(properties.getProperty(CanalConstants.CANAL_ZKSERVERS))){
                logger.error("****************************** canal zk is blank ***************************************\n");
                return;
            }
            /**
             * 设置canal，zk的配置信息
             */
            CanalZkStatusUtil.setZkServerIp(properties.getProperty(CanalConstants.CANAL_ZKSERVERS));
            CanalZkStatusUtil.setToken(token);

            logger.info("zkServers="+properties.getProperty(CanalConstants.CANAL_ZKSERVERS));
            controller = new CanalController(properties);
            /*
            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    shutdown();
                }
            });
            */
            start();
            logger.info("****************************** canal server start success ***************************************\n");
        } catch (Throwable e) {
            logger.error("## Something goes wrong when starting up the canal Server:\n{}",e);
            logger.info("****************************** canal server start fail ***************************************\n");
        }
        logger.info("*********************************************************************\n");
    }

    public void start() throws Throwable {
        controller.start();
    }

    public void shutdown(){
        try {
            logger.info("## stop the canal server");
            controller.stop();
        } catch (Throwable e) {
            logger.warn("##something goes wrong when stopping canal Server:\n{}", e);
        } finally {
            logger.info("## canal server is down.");
        }
    }

    public void setConfigs(List<String> configs) {
        this.configs = configs;
    }

    public void setDestinations(String destinations) {
        this.destinations = destinations;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private  boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }
}
