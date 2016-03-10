package com.jd.distributed.worker;

import com.jd.distributed.worker.config.ZooKeeperConfig;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.state.ConnectionStateListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.CloseableUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

/**
 * Created by wangyingjie1 on 2016/3/10.
 */
public class SimpleCuratorFrameworkFactory  implements ZooKeeperClientFactory, InitializingBean {

    private ZooKeeperConfig zooKeeperConfig;
    private ConnectionStateListener connectionStateListener;

    private CuratorFramework curatorFramework;

    private void createCuratorFramework() {
        Assert.state(this.zooKeeperConfig != null, "zooKeeperConfig must be set when using 'zooKeeperConfig'");
        curatorFramework = CuratorFrameworkFactory.newClient(zooKeeperConfig.getConnectString(), new ExponentialBackoffRetry(1000, 3));
        if (connectionStateListener != null) {
            curatorFramework.getConnectionStateListenable().addListener(connectionStateListener);
        }
    }

    public void start() {
        curatorFramework.start();
    }

    public void close() {
        CloseableUtils.closeQuietly(curatorFramework);
    }

    public void afterPropertiesSet() throws Exception {
        createCuratorFramework();
    }

    public ConnectionStateListener getConnectionStateListener() {
        return connectionStateListener;
    }

    public void setConnectionStateListener(ConnectionStateListener connectionStateListener) {
        this.connectionStateListener = connectionStateListener;
    }

    public ZooKeeperConfig getZooKeeperConfig() {
        return zooKeeperConfig;
    }

    public void setZooKeeperConfig(ZooKeeperConfig zooKeeperConfig) {
        this.zooKeeperConfig = zooKeeperConfig;
    }

    public CuratorFramework getCuratorFramework() {
        return curatorFramework;
    }

}