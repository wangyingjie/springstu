package com.jd.distributed.worker;

import com.jd.distributed.worker.config.ZooKeeperConfig;
import org.apache.curator.framework.CuratorFramework;

/**
 * Created by wangyingjie1 on 2016/3/10.
 */
public interface ZooKeeperClientFactory {

    public ZooKeeperConfig getZooKeeperConfig();

    public CuratorFramework getCuratorFramework();
}
