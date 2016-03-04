package com.jd.jmi.order.canal.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by changpan on 2015/5/21.
 */
public class DateFormatUtils {

    /**
     * The format used is <tt>yyyyMMddHHmmss</tt>.
     */
    public static final SimpleDateFormat YYYYMMDDHHMMSS = new SimpleDateFormat("yyyyMMddHHmmss");

    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static final SimpleDateFormat FULL_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 时间格式化
     * @param date
     * @param format
     * @return
     */
    public static String getFomatTime(Date date,SimpleDateFormat format){
        try {
            return format.format(date);
        }catch (Exception e){
            return "";
        }
    }

    public static Date getDate(String date,SimpleDateFormat format){
        try{
           return format.parse(date);
        }catch (Exception e){
            return null;
        }

    }

}
