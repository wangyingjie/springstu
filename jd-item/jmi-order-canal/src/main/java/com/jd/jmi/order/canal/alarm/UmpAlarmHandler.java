package com.jd.jmi.order.canal.alarm;

import com.alibaba.otter.canal.common.AbstractCanalLifeCycle;
import com.alibaba.otter.canal.common.alarm.CanalAlarmHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基于 ump 的alarm机制实现
 * Created by changpan on 2015/12/7.
 */
public class UmpAlarmHandler  extends AbstractCanalLifeCycle implements CanalAlarmHandler {

    private static final String CANAL_SERVER_JMI_HANDLER_ALARM = "canal_server_jmi_handler_alarm";

    private static final Logger logger = LoggerFactory.getLogger(UmpAlarmHandler.class);

    public void sendAlarm(String destination, String msg) {
        logger.error("destination:{}[{}]", new Object[] { destination, msg });
        //Profiler.businessAlarm(CANAL_SERVER_JMI_HANDLER_ALARM, String.format("订单组件:canal服务端des={},msg={}",destination,msg));
    }

}
