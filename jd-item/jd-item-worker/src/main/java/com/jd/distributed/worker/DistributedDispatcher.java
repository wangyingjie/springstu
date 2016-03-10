package com.jd.distributed.worker;

import com.jd.distributed.worker.execute.DistributedExecutor;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.leader.CancelLeadershipException;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListener;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.utils.CloseableUtils;

import java.io.Closeable;
import java.util.concurrent.TimeUnit;
/**
 * Created by wangyingjie1 on 2016/3/10.
 */
public class DistributedDispatcher  implements LeaderSelectorListener {

    private String leaderPath;
    private ZooKeeperClientFactory zooKeeperClientFactory;
    private volatile LeaderSelector leaderSelector;
    private DistributedContext distributedContext;
    private DistributedExecutor distributedExecutor;

    public DistributedDispatcher(ZooKeeperClientFactory zooKeeperClientFactory, DistributedContext distributedContext) {
        this.zooKeeperClientFactory = zooKeeperClientFactory;
        this.distributedContext = distributedContext;
        this.distributedExecutor = distributedContext.getDistributedExecutor();
        this.leaderPath = buildLeaderPath();
    }

    private String buildLeaderPath() {
        StringBuilder stringBuilder = new StringBuilder();
        String rootPath = zooKeeperClientFactory.getZooKeeperConfig().getRootPath();
        stringBuilder.append(rootPath);
        if (!rootPath.endsWith("/")) {
            stringBuilder.append("/");
        }
        stringBuilder.append(distributedContext.getTargetName());
        stringBuilder.append("/");
        stringBuilder.append(distributedContext.getGroupIndex());
        return stringBuilder.toString();
    }

    public void start() {
        if (leaderSelector == null) {
            synchronized (LeaderSelector.class) {
                if (leaderSelector == null) {
                    leaderSelector = new LeaderSelector(zooKeeperClientFactory.getCuratorFramework(), leaderPath, this);
                    leaderSelector.autoRequeue();
                    leaderSelector.start();
                }
            }
        }
    }

    public boolean isClosed() {
        return leaderSelector == null;
    }

    public void close() {
        if (leaderSelector != null) {
            synchronized (LeaderSelector.class) {
                if (leaderSelector != null) {
                    closeQuietly(leaderSelector);
                    leaderSelector = null;
                }
            }
        }
    }

    public boolean hasLeadership() {
        if (leaderSelector != null) {
            return leaderSelector.hasLeadership();
        }
        return false;
    }

    private boolean isGroupMode() {
        return distributedExecutor.isGroupMode();
    }

    private void closeQuietly(Closeable closeable) {
        try {
            CloseableUtils.closeQuietly(closeable);
        } catch (Exception e) {
            //ignore
        }
    }

    public void takeLeadership(CuratorFramework client) throws Exception {
        distributedExecutor.takeLeadership(distributedContext);
        while (isGroupMode()) {
            TimeUnit.SECONDS.sleep(10);
        }
    }

    public void stateChanged(CuratorFramework client, ConnectionState newState) {
        if (newState == ConnectionState.SUSPENDED || newState == ConnectionState.LOST) {
            throw new CancelLeadershipException();
        }
    }

    public DistributedExecutor getDistributedExecutor() {
        return distributedExecutor;
    }

    public ZooKeeperClientFactory getZooKeeperClientFactory() {
        return zooKeeperClientFactory;
    }
}
