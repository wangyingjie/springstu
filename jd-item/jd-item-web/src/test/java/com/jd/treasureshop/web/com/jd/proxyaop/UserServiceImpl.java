package com.jd.treasureshop.web.com.jd.proxyaop;

/**
 * Created by wangyingjie1 on 2016/3/3.
 */
public class UserServiceImpl implements IUserService {


    @Override
    public void sayHello() {
        System.out.println("Hello User");
    }
}
