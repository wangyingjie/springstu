package com.jd.treasure.service.com.jd.treasure.service.impl;

import com.jd.treasure.service.IHelloWorldService;
import org.springframework.stereotype.Service;

/**
 * Created by wangyingjie1 on 2016/2/22.
 */
@Service("helloWorldService")
public class HelloWorldServiceImpl implements IHelloWorldService {

    @Override
    public String sayHello() {
        System.out.println("Hello World^^^^^^^^^^^^");
        return "Hello";
    }

    @Override
    public void sayBefore(String param) {
        System.out.println("Hello World " + param);
    }


}
