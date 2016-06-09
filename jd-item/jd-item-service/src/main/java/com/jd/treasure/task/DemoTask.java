package com.jd.treasure.task;

import com.taobao.pamirs.schedule.IScheduleTaskDeal;
import com.taobao.pamirs.schedule.IScheduleTaskDealSingle;
import com.taobao.pamirs.schedule.TaskItemDefine;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangyingjie1 on 2016/6/9.
 */
public class DemoTask implements IScheduleTaskDealSingle<TBTask>, IScheduleTaskDeal<TBTask> {

    /**
     * 数据采集
     *
     * @param taskItemNum--分配的任务项 taskItemList--总任务项
     *                            eachFetchDataNum--采集任务数量
     */
    @Override
    public List<TBTask> selectTasks(String taskParameter, String ownSign, int taskItemNum, List<TaskItemDefine> taskItemList,
                                    int eachFetchDataNum) throws Exception {
        List<TBTask> taskList = new LinkedList<TBTask>();
        //客户端根据条件进行数据采集start

        //客户端根据条件进行数据采集end
        return taskList;
    }

    @Override
    public Comparator getComparator() {
        return null;
    }

    /**
     * 数据处理
     */
    @Override
    public boolean execute(TBTask task, String ownSign) throws Exception {
        //客户端pop任务进行处理start

        //客户端pop任务进行处理end
        return true;
    }

}
