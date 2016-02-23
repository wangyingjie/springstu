package com.jd.treasureshop.web.com.jd.service.aop;

import com.jd.treasure.dao.card.CardDao;
import com.jd.treasure.service.IHelloWorldService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wangyingjie1 on 2016/2/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-config-test.xml")
public class TestAopHelloWorld {

    @Autowired
    @Qualifier("helloWorldService")
    private IHelloWorldService helloWorldService;


    @Test
    public void testHello(){
        //ApplicationContext ctx =  new ClassPathXmlApplicationContext("chapter6/helloworld.xml");
        //IHelloWorldService helloworldService = ctx.getBean("helloWorldService", IHelloWorldService.class);
        helloWorldService.sayHello();
    }
}
