package com.jd.distributed.worker.config;

/**
 * Created by wangyingjie1 on 2016/3/10.
 */
public class ZooKeeperConfig {


    private String connectString;
    private String rootPath;

    public String getConnectString() {
        return connectString;
    }

    public void setConnectString(String connectString) {
        this.connectString = connectString;
    }

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    @Override
    public String toString() {
        return "ZooKeeperConfig{" +
                "connectString='" + connectString + '\'' +
                ", rootPath='" + rootPath + '\'' +
                '}';
    }
}
