package com.jd.treasure.task;

import com.taobao.pamirs.schedule.strategy.ScheduleStrategy;
import com.taobao.pamirs.schedule.taskmanager.ScheduleTaskType;

/**
 * Created by wangyingjie1 on 2016/6/8.
 */
public class InitScheduleTask {

    // 创建任务调度DemoTask的基本信息
    private  ScheduleTaskType baseTaskType;

    private ScheduleStrategy scheduleStrategy;

    public ScheduleTaskType getBaseTaskType() {
        return baseTaskType;
    }

    public void setBaseTaskType(ScheduleTaskType baseTaskType) {
        this.baseTaskType = baseTaskType;
    }

    public ScheduleStrategy getScheduleStrategy() {
        return scheduleStrategy;
    }

    public void setScheduleStrategy(ScheduleStrategy scheduleStrategy) {
        this.scheduleStrategy = scheduleStrategy;
    }
}
