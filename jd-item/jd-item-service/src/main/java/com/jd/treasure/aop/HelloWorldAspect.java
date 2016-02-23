package com.jd.treasure.aop;

/**
 * Created by wangyingjie1 on 2016/2/22.
 */
public class HelloWorldAspect {

    //前置通知
    public void beforeAdvice() {
        System.out.println("===========before advice");
    }

    //后置最终通知
    public void afterFinallyAdvice() {
        System.out.println("===========after finally advice");
    }

    public void beforeAdvice(String param) {
        System.out.println("===========before advice param:" + param);
    }
}
