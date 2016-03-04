package com.jd.jmi.order.canal.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by changpan on 2015/12/3.
 */
public class CanalClientNode {

    /**
     * canal server 工作ip
     */
    private String serverIp;

    /**
     * canal server服务ip列表
     */
    private List<String> serverIps = new ArrayList<String>();

    /**
     * canal client ip
     */
    private String clientIp;

    /**
     * 同步数据库ip
     */
    private String dbIp;

    private String postion;

    private String time;

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public void addIp(String ip){
        this.serverIps.add(ip);
    }

    public List<String> getServerIps() {
        return serverIps;
    }

    public void setServerIps(List<String> serverIps) {
        this.serverIps = serverIps;
    }


    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getPostion() {
        return postion;
    }

    public void setPostion(String postion) {
        this.postion = postion;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDbIp() {
        return dbIp;
    }

    public void setDbIp(String dbIp) {
        this.dbIp = dbIp;
    }
}
