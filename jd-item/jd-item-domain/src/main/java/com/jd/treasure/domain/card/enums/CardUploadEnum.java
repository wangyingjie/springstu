package com.jd.treasure.domain.card.enums;

/**
 * Created by zhangqingwei on 2015/12/12.
 */
public enum CardUploadEnum {

    NOT_UPLOAD(1,"未上传卡密"),
    UPLOADED(2,"已上传卡密");

    private Integer type;
    private String value;

    CardUploadEnum(Integer type,String value){
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
