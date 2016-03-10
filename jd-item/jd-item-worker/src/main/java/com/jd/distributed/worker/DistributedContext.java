package com.jd.distributed.worker;

import com.jd.distributed.worker.config.Group;
import com.jd.distributed.worker.execute.DistributedExecutor;

import java.util.List;

/**
 * Created by wangyingjie1 on 2016/3/10.
 */
public class DistributedContext {

    private final String targetName;
    private final String description;
    private final List<Group> groups;
    private final String localId;
    private final int groupIndex;
    private final Group group;

    private DistributedControl distributedControl;
    private DistributedExecutor distributedExecutor;

    public DistributedContext(DistributedControl distributedControl) {
        this.distributedControl = distributedControl;
        this.distributedExecutor = distributedControl.getDistributedExecutor();
        this.targetName = distributedControl.getTargetName();
        this.description = distributedControl.getDescription();
        this.localId = distributedControl.getLocalId();
        this.groups = distributedControl.getGroups();
        this.groupIndex = distributedControl.getGroupIndex();
        this.group = groups.get(groupIndex);
    }

    public String getTargetName() {

        return distributedControl.getTargetName();
    }

    public String getDescription() {
        return distributedControl.getDescription();
    }

    public List<Group> getGroups() {
        return groups;
    }

    public int getGroupIndex() {
        return groupIndex;
    }

    public Group getGroup() {
        return group;
    }

    public String getLocalId() {
        return localId;
    }

    public DistributedControl getDistributedControl() {
        return distributedControl;
    }

    public DistributedExecutor getDistributedExecutor() {
        return distributedExecutor;
    }
}
