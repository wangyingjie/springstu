package com.jd.treasureshop.web.base.controller;

import com.jd.treasure.service.worker.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * User: ckm
 * Date: 15-10-29
 * Time: 下午10:29
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class IndexController  {

    @Autowired
    private WorkerService workerService;

    @RequestMapping("/")
    public ModelAndView index() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");

        workerService.doOnceMethod("rechargeOnce11");

        return mv;
    }


}
