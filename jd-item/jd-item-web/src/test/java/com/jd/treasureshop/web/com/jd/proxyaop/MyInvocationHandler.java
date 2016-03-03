package com.jd.treasureshop.web.com.jd.proxyaop;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by wangyingjie1 on 2016/3/3.
 *
 * 可以代理任意对象
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;//属于目标对象

    public MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before********************");
        Object result = method.invoke(target, args);
        System.out.println("after********************");

        return result;
    }

    //获取目标对象的一个实例
    public  Object getProxy(){
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                target.getClass().getInterfaces(), this);
    }

}
