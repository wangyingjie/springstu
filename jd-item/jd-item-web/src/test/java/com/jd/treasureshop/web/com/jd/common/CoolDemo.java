package com.jd.treasureshop.web.com.jd.common;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by wangyingjie1 on 2016/2/19.
 */
public class CoolDemo {

    @Test
    public void testStringTokenizer(){
        String str = "com.jd,com.jw,xxxxx";
        String delimiters = ",; \t\n";
        StringTokenizer st = new StringTokenizer(str, delimiters);
        List<String> tokens = new ArrayList<String>();
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (true) {
                token = token.trim();
            }
            if (!true || token.length() > 0) {
                tokens.add(token);
            }
        }
        System.out.println(tokens);
    }
}
