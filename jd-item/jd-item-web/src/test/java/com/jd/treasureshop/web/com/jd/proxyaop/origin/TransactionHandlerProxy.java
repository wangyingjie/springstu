package com.jd.treasureshop.web.com.jd.proxyaop.origin;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by wangyingjie1 on 2016/3/3.
 */
public class TransactionHandlerProxy {

    private Handler faceHandler;

    public void setFaceHandler(Handler faceHandler) {
        this.faceHandler = faceHandler;
    }

    public TransactionHandlerProxy() {
    }

    public TransactionHandlerProxy(Handler faceHandler) {
        this.faceHandler = faceHandler;
    }

    public Handler getProxyHandler() {
        return (Handler) Proxy.newProxyInstance(HandlerProxy.class.getClassLoader(), FaceHandler.class.getInterfaces(), new MyInvocationHandler(faceHandler));
    }

    private class MyInvocationHandler implements InvocationHandler {

        private Object target;

        public MyInvocationHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            if (method.getName().equals("save")) {
                System.out.println(" proxy save method ");
                return proxy == args;
            } else if (method.getName().equals("timeOut")) {
                System.out.println(" proxy timeout method ");
                return 1;
            }
            System.out.println("before2********************");
            Object result = method.invoke(target, args);
            System.out.println("after2********************");

            return result;
        }
    }
}
