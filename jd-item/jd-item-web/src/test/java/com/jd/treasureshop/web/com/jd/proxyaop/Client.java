package com.jd.treasureshop.web.com.jd.proxyaop;

/**
 * Created by wangyingjie1 on 2016/3/3.
 */
public class Client {

    public static void main(String[] args) {

        IUserService userServiceTraget = new UserServiceImpl();
        MyInvocationHandler handler = new MyInvocationHandler(userServiceTraget);
        // 1、强制转化为接口的实现类  指定报错  原因是Jdk的动态代理其实返回的是 Jdk自己创建的代理对象的实体类
        //  运行ProxyGeneratorUtils  可以看到$Proxy11.class 文件反编译 之后源码如： proxy11.java   该类实现了 IUserService 接口
        //UserServiceImpl proxy = (UserServiceImpl) handler.getProxy();

        // 2、那么什么地方调用了代理对象的  invoke 方法呢？
        IUserService proxy = (IUserService) handler.getProxy();
        proxy.sayHello();
    }
}
