package com.jd.treasureshop.web.com.jd.worker;

import org.apache.commons.lang.StringUtils;
import org.quartz.JobDetail;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import java.lang.reflect.Method;

/**
 * Created by wangyingjie1 on 2016/3/10.
 */
public class WorkerTest {


    public void doOnceMethod(String quartzBeanId){
        try {
            if(StringUtils.isEmpty(quartzBeanId)){
               // result.setResultCode("system.error");
            }

            WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
            ServletContext servletContext = webApplicationContext.getServletContext();

            if(servletContext == null){
                //result.setResultCode("system.error");
            }
            WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

            MethodInvokingJobDetailFactoryBean b = ((MethodInvokingJobDetailFactoryBean) (((JobDetail) wac.getBean(quartzBeanId)).getJobDataMap().get("methodInvoker")));

            Method method = b.getPreparedMethod();
            method.invoke(b.getTargetObject(),null);
        }  catch (Exception e) {
        }
    }
}
