package com.jd.treasureshop.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangyingjie1 on 2016/6/8.
 */
public class Demo {

    public static void main(String[] args) {

        Map<String, Object> map = new HashMap<String, Object>();
        String key = "xxx";
        map.put(key, new Date());

        if (map.get(key) instanceof Date){

        }

        //String sss = (String) map.get(key);

        System.out.println("xxxxxxxxxxxx------" + "".toCharArray());
    }
}
