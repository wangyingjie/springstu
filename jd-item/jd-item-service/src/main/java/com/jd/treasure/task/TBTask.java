package com.jd.treasure.task;

/**
 * Created by wangyingjie1 on 2016/6/9.
 */
public class TBTask {

    private static final long RAW_ID = 10000000000L;

    public static void main(String[] args) {
        //10000087 +

        long routeId = 10000087L;
        long sequenceId = 111L;

        System.out.println(getX(routeId, sequenceId));
    }

    private static long getX(long routeId, long sequenceId) {
        return routeId * RAW_ID + sequenceId;
    }
}
