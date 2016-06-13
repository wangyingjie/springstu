package com.jd.treasure.task;

import com.taobao.pamirs.schedule.IScheduleTaskDealSingle;
import com.taobao.pamirs.schedule.TaskItemDefine;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangyingjie1 on 2016/6/9.
 */
public class DemoTask implements IScheduleTaskDealSingle<DemoTask> {

    private final int test = 10000;

    public final String demoStr = "xxxx";

    /**
     * 数据采集
     *
     * @param taskItemNum--分配的任务项 taskItemList--总任务项
     *                            eachFetchDataNum--采集任务数量
     */
    @Override
    public List<DemoTask> selectTasks(String taskParameter, String ownSign, int taskItemNum, List<TaskItemDefine> taskItemList,
                                      int eachFetchDataNum) throws Exception {

        System.out.println("taskParameter====>" + taskParameter + " \t ownSign====>" + ownSign +
                " \t taskItemNum====>" + taskItemNum + " \t eachFetchDataNum====>" + eachFetchDataNum + " \t taskItemList====>" + taskItemList);

        List<DemoTask> taskList = new LinkedList<DemoTask>();
        //客户端根据条件进行数据采集start
        for (int i=0; i<5; i++){
            taskList.add(new DemoTask());
        }

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
    public boolean execute(DemoTask task, String ownSign) throws Exception {
        //客户端pop任务进行处理start


        System.out.println(task + "------" + ownSign);
        System.out.println("task====>" + task + " \t ownSign====>" + ownSign);


        //客户端pop任务进行处理end
        return true;
    }

}
