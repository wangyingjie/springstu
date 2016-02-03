package com.jd.treasure.domain.card.enums;

/**
 * Created by zhangqingwei on 2015/12/19.
 */
public enum CardTypeEnum {

    /** 商家id_卡号_密码 */
    RECHARGE_CARD(2, "RECHARGE_CARD_%s_%s_%s", "充值卡");

    private Integer type;
    private String prefix;
    private String value;

    CardTypeEnum(Integer type, String prefix, String value) {
        this.type = type;
        this.prefix = prefix;
        this.value = value;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String format(Object... values) {
        return String.format(prefix, values);
    }
}
