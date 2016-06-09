package com.jd.treasure.task;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wangyingjie1 on 2016/6/8.
 */
@Controller
@RequestMapping(("/task"))
public class TaskController {

    @RequestMapping("/execute")
    public void executeTask(){

        long taskId = 10;

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxx" + taskId);
    }
}
