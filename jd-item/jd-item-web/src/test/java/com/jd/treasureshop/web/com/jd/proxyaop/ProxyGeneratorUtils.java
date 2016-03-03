package com.jd.treasureshop.web.com.jd.proxyaop;

import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by wangyingjie1 on 2016/3/3.
 */
public class ProxyGeneratorUtils {

    /**
     * 把代理类的字节码写到硬盘上
     * @param path 保存路径
     */
    public static void writeProxyClassToHardDisk(String path) {
        // 第一种方法，这种方式在刚才分析ProxyGenerator时已经知道了
        // System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", true);

        // 第二种方法
        // 获取代理类的字节码
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy11", UserServiceImpl.class.getInterfaces());

        FileOutputStream out = null;

        try {
            out = new FileOutputStream(path);
            out.write(classFile);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testGenerateProxyClass() {
        ProxyGeneratorUtils.writeProxyClassToHardDisk("e:/$Proxy11.class");
    }
}
