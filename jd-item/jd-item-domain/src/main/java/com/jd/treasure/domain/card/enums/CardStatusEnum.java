package com.jd.treasure.domain.card.enums;

/**
 * 卡密状态
 * User: guohaifei
 * Date: 2015/12/9
 * Time: 14:21
 * To change this template use File | Settings | File Templates.
 */
public enum CardStatusEnum {
    UN_USE(1,"未使用"),
    USED(2,"已使用");

    private Integer type;
    private String value;

    CardStatusEnum(Integer type,String value){
        this.type = type;
        this.value = value;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
