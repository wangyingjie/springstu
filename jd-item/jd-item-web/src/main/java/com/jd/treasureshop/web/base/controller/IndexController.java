package com.jd.treasureshop.web.base.controller;

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

    @RequestMapping("/")
    public ModelAndView index() {

        return new ModelAndView("index");
    }


}
