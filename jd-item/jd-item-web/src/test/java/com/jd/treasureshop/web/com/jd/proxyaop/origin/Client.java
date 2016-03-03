package com.jd.treasureshop.web.com.jd.proxyaop.origin;

/**
 * Created by wangyingjie1 on 2016/3/3.
 */
public class Client {

    public static void main(String[] args) {
        TransactionHandlerProxy proxy = new TransactionHandlerProxy(new FaceHandler());
        Handler faceHandler = proxy.getProxyHandler();

        boolean flag = faceHandler.save();

        Object object = faceHandler.getHandler();

        Integer integer = faceHandler.timeOut();
    }
}
