package com.jd.jmi.order.canal.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.otter.canal.client.impl.running.ClientRunningData;
import com.alibaba.otter.canal.common.zookeeper.ZkClientx;
import com.alibaba.otter.canal.common.zookeeper.running.ServerRunningData;
import com.alibaba.otter.canal.deployer.CanalConstants;
import com.alibaba.otter.canal.protocol.position.LogPosition;
import com.jd.jmi.order.canal.model.CanalClientNode;
import org.I0Itec.zkclient.exception.ZkNoNodeException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.*;

/**
 * Created by changpan on 2015/12/9.
 */
public class CanalZkStatusUtil {

    /**
     * zk服务器ip
     */
    private static String zkServerIp = null;

    private static final String CANAL_DESTINATIONS = "/otter/canal/destinations";

    /**
     * 加密串
     */
    private static String token = "ew23445#R%%@DGVWp)";

    private static final Log logger = LogFactory.getLog(CanalZkStatusUtil.class);

    /**
     * 获取canal的运行状态
     *
     * @return
     */
    public static Map<String,CanalClientNode> getCanalClientNodes() {
        Map<String,CanalClientNode> nodes = new HashMap<String, CanalClientNode>();
        try {
            if (zkServerIp == null) {
                logger.error("zkServerIp没有set");
                return nodes;
            }
            ZkClientx zkClientx = ZkClientx.getZkClient(zkServerIp);
            if (zkClientx.exists(CANAL_DESTINATIONS)) {
                List<String> des = zkClientx.getChildren(CANAL_DESTINATIONS);
                for (int i = 0; i < des.size(); i++) {
                    CanalClientNode node = new CanalClientNode();
                    String desStr = des.get(i);
                    String desPath = CANAL_DESTINATIONS + "/" + desStr;
                    ServerRunningData serverRunningData = (ServerRunningData) getObject(zkClientx, desPath + "/running", ServerRunningData.class);
                    if (serverRunningData != null && serverRunningData.isActive()) {
                        node.setServerIp(serverRunningData.getAddress());
                    }
                    ClientRunningData clientRunningData = (ClientRunningData) getObject(zkClientx, desPath + "/1001/running", ClientRunningData.class);
                    if (clientRunningData != null && clientRunningData.isActive()) {
                        node.setClientIp(clientRunningData.getAddress());
                    }
                    LogPosition logPosition = (LogPosition) getObject(zkClientx, desPath + "/1001/cursor", LogPosition.class);
                    if (logPosition != null) {
                        node.setPostion(logPosition.getPostion().getPosition() + "");
                        node.setDbIp(logPosition.getIdentity().getSourceAddress().getAddress().getHostAddress());
                        node.setTime(DateFormatUtils.getFomatTime(new Date(logPosition.getPostion().getTimestamp()), DateFormatUtils.FULL_DATE_FORMAT));
                    }
                    String clusterPath = desPath + "/cluster";
                    if (zkClientx.exists(clusterPath)) {
                        node.setServerIps(zkClientx.getChildren(clusterPath));
                    }
                    nodes.put(desStr,node);
                }
            }
        } catch (ZkNoNodeException noNodeExc) {
            logger.error("节点不存在" + noNodeExc.getMessage());
        }
        return nodes;
    }

    public static String getData(ZkClientx zkClientx, String path) {
        byte[] ds = zkClientx.readData(path, true);
        if (null != ds && ds.length > 0) {
            return new String(ds);
        }
        return "";
    }

    public static Object getObject(ZkClientx zkClientx, String path, Class cla) {
        String canalRun = getData(zkClientx, path);
        if (canalRun != null && canalRun.length() > 0) {
            try {
                return JSON.parseObject(canalRun, cla);
            } catch (Exception e) {
            }
        }
        return null;
    }

    public static void setZkServerIp(String zkServerIp) {
        CanalZkStatusUtil.zkServerIp = zkServerIp;
    }

    public static void setToken(String token) {
        CanalZkStatusUtil.token = token;
    }

    /**
     * 获取md5加密串
     *
     * @return
     */
    public static String getToken() {
        return MD5Util.md5Hex(DateFormatUtils.getFomatTime(new Date(), DateFormatUtils.SIMPLE_DATE_FORMAT) + token, "UTF-8");
    }

    public static void main(String[] args) {
        System.out.println(getToken());
        zkServerIp = "192.168.202.78:2181,192.168.193.106:2181";
        Map<String,CanalClientNode> nodes = getCanalClientNodes();
        System.out.println(JSON.toJSONString(nodes));
    }
}
