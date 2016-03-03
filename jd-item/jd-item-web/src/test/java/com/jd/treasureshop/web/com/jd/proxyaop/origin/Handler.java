package com.jd.treasureshop.web.com.jd.proxyaop.origin;

/**
 * Created by wangyingjie1 on 2016/3/3.
 */
public interface Handler {

    public Object getHandler();

    public boolean save();

    public Integer timeOut();
}
