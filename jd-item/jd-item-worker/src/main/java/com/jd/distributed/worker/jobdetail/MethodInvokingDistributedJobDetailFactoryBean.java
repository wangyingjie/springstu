package com.jd.distributed.worker.jobdetail;

import com.jd.distributed.worker.DistributedContext;
import com.jd.distributed.worker.DistributedControl;
import com.jd.distributed.worker.DistributedDispatcher;
import com.jd.distributed.worker.ZooKeeperClientFactory;
import com.jd.distributed.worker.config.Group;
import com.jd.distributed.worker.execute.DistributedExecutor;
import org.quartz.JobDetail;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.util.Assert;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by wangyingjie1 on 2016/3/10.
 */
public class MethodInvokingDistributedJobDetailFactoryBean  extends MethodInvokingJobDetailFactoryBean implements DisposableBean, DistributedControl {

    private String targetName;
    private String description;
    private List<Group> groups;
    private String localId;
    private int groupIndex;

    private ZooKeeperClientFactory zooKeeperClientFactory;
    private DistributedExecutor distributedExecutor;
    private DistributedContext distributedContext;
    private DistributedDispatcher distributedDispatcher;

    @Override
    protected void postProcessJobDetail(JobDetail jobDetail) {
        Object targetObject = getTargetObject();
        if (targetObject instanceof DistributedExecutor) {
            DistributedExecutor distributedExecutor = (DistributedExecutor) targetObject;

            Assert.state(this.zooKeeperClientFactory != null, "zooKeeperClientFactory must be set when using 'zooKeeperClientFactory'");
            Assert.notEmpty(this.groups, "groups must be set when using 'groups'");

            this.distributedExecutor = distributedExecutor;
            this.localId = distributedExecutor.getLocalId();
            this.groupIndex = queryGroupIndex();

            if (groupIndex > -1) {
                distributedContext = new DistributedContext(this);
                distributedDispatcher = new DistributedDispatcher(zooKeeperClientFactory, distributedContext);
                distributedExecutor.postProcess(distributedContext);
                if (distributedExecutor.isGroupMode()) {
                    //分组运行模式则启动leader
                    distributedDispatcher.start();
                }
            }
        }
    }

    private int queryGroupIndex() {
        int index = 0;
        for (Group group : groups) {
            for (String id : group.getIds()) {
                if (id.equals(localId)) {
                    return index;
                }
            }
            index++;
        }
        return -1;
    }

    public String getTargetName() {
        if (targetName == null) {
            targetName = getJobDetailName();
        }
        return targetName;
    }

    public String getDescription() {
        return description;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public String getLocalId() {
        return localId;
    }

    public int getGroupIndex() {
        return groupIndex;
    }

    private String getJobDetailName() {
        JobDetail jobDetail = (JobDetail) getObject();
        return jobDetail.getName();
    }

    @Override
    public Object invoke() throws InvocationTargetException, IllegalAccessException {
        if (distributedDispatcher != null) {
            if (distributedExecutor.isGroupMode()) {
                //分组运行模式则验证leader
                if (distributedDispatcher.isClosed()) {
                    distributedDispatcher.start();
                }
                if (distributedDispatcher.hasLeadership()) {
                    return super.invoke();
                } else {
                    //分组机器启动分组模式不是leader则执行notExecute方法
                    distributedExecutor.notExecute(distributedContext);
                    return null;
                }
            } else {
                //非分组模式则直接执行业务逻辑
                return super.invoke();
            }
        } else {
            //不是分组中的机器则直接执行业务逻辑
            return super.invoke();
        }
    }

    public void destroy() throws Exception {
        if (distributedDispatcher != null) {
            distributedDispatcher.close();
        }
    }

    public void setZooKeeperClientFactory(ZooKeeperClientFactory zooKeeperClientFactory) {
        this.zooKeeperClientFactory = zooKeeperClientFactory;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DistributedDispatcher getDistributedDispatcher() {
        return distributedDispatcher;
    }

    public DistributedExecutor getDistributedExecutor() {
        return distributedExecutor;
    }

}