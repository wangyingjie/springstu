package com.jd.treasure.domain.card.param;

/**
 * 卡密表查询参数
 * User: guohaifei
 * Date: 2015/12/9
 * Time: 13:57
 * To change this template use File | Settings | File Templates.
 */
public class CardQuery {
    /** 夺宝项id **/
    private Long itemId;
    /** 商家id **/
    private Long venderId;
    /** 卡密状态1:未使用  2：已使用 **/
    private Integer status;
    /** 夺宝分类 1.实物  2. 充值卡 **/
    private Integer itemType;
    private Integer yn;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getVenderId() {
        return venderId;
    }

    public void setVenderId(Long venderId) {
        this.venderId = venderId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    public Integer getYn() {
        return yn;
    }

    public void setYn(Integer yn) {
        this.yn = yn;
    }
}
