package com.jd.treasureshop.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * User: ckm
 * Date: 2015/12/7
 * Time: 14:53
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-config-test.xml")
public class VenderTest {


    @Test
    public void vender() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(3);
    }
}
