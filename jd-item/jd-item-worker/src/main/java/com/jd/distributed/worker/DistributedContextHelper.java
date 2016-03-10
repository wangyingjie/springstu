package com.jd.distributed.worker;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangyingjie1 on 2016/3/10.
 */
public class DistributedContextHelper {

    public final static Map<String, DistributedContext> distributedContextMap = new HashMap<String, DistributedContext>();

    public static void addDistributedContext(DistributedContext distributedContext) {
        distributedContextMap.put(distributedContext.getTargetName(), distributedContext);
    }

    public static Collection<DistributedContext> getDistributedContexts() {
        return distributedContextMap.values();
    }
}


