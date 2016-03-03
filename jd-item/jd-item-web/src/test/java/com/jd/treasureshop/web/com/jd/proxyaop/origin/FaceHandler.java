package com.jd.treasureshop.web.com.jd.proxyaop.origin;

/**
 * Created by wangyingjie1 on 2016/3/3.
 */
public class FaceHandler implements Handler {

    @Override
    public Object getHandler() {

        System.out.println("MY faceHanlder **************");
        return null;
    }

    @Override
    public boolean save() {
        System.out.println(" save execute ******************");
        return false;
    }

    @Override
    public Integer timeOut() {

        System.out.println(" time out execute ***************");
        return null;
    }
}
