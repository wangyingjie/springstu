package com.jd.distributed.worker.config;

import java.util.List;

/**
 * Created by wangyingjie1 on 2016/3/10.
 */
public class Group {

    private String shardingDs;
    private List<String> shardingIdList;
    private String name;
    private List<String> ids;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public String getShardingDs() {
        return shardingDs;
    }

    public void setShardingDs(String shardingDs) {
        this.shardingDs = shardingDs;
    }

    public List<String> getShardingIdList() {
        return shardingIdList;
    }

    public void setShardingIdList(List<String> shardingIdList) {
        this.shardingIdList = shardingIdList;
    }
}
