package com.jd.distributed.worker;

import com.jd.distributed.worker.config.Group;
import com.jd.distributed.worker.execute.DistributedExecutor;

import java.util.List;

/**
 * Created by wangyingjie1 on 2016/3/10.
 */
public interface DistributedControl {

    public DistributedExecutor getDistributedExecutor();

    public String getTargetName();

    public String getDescription();

    public List<Group> getGroups();

    public String getLocalId();

    public int getGroupIndex();

}
