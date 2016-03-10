package com.jd.treasure.service.worker;

/**
 * Created by wangyingjie1 on 2016/3/10.
 */
public class RechargeTaskHandler {

    private String shardingId;

    public String getShardingId() {
        return shardingId;
    }

    public void setShardingId(String shardingId) {
        this.shardingId = shardingId;
    }

    public void doWork(){
        System.out.println("xxxxxxxxxxxxxxx" +  shardingId);
    }
}
