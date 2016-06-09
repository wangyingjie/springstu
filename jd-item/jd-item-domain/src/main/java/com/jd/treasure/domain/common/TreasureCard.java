package com.jd.treasure.domain.common;

import java.io.Serializable;
import java.util.Date;

public class TreasureCard implements Serializable{
    
    private static final long serialVersionUID = 3787847102292607812L;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column treasure_card.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column treasure_card.item_id
     *
     * @mbggenerated
     */
    private Long itemId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column treasure_card.vender_id
     *
     * @mbggenerated
     */
    private Long venderId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column treasure_card.sort_id
     *
     * @mbggenerated
     */
    private Integer sortId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column treasure_card.vender_id
     *
     * @mbggenerated
     */
    private String uniqueId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column treasure_card.card_number
     *
     * @mbggenerated
     */
    private String cardNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column treasure_card.card_password
     *
     * @mbggenerated
     */
    private String cardPassword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column treasure_card.status
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column treasure_card.item_type
     *
     * @mbggenerated
     */
    private Integer itemType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column treasure_card.yn
     *
     * @mbggenerated
     */
    private Integer yn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column treasure_card.modified
     *
     * @mbggenerated
     */
    private Date modified;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column treasure_card.created
     *
     * @mbggenerated
     */
    private Date created;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column treasure_card.id
     *
     * @return the value of treasure_card.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column treasure_card.id
     *
     * @param id the value for treasure_card.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column treasure_card.item_id
     *
     * @return the value of treasure_card.item_id
     *
     * @mbggenerated
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column treasure_card.item_id
     *
     * @param itemId the value for treasure_card.item_id
     *
     * @mbggenerated
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column treasure_card.vender_id
     *
     * @return the value of treasure_card.vender_id
     *
     * @mbggenerated
     */
    public Long getVenderId() {
        return venderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column treasure_card.vender_id
     *
     * @param venderId the value for treasure_card.vender_id
     *
     * @mbggenerated
     */
    public void setVenderId(Long venderId) {
        this.venderId = venderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column treasure_card.card_number
     *
     * @return the value of treasure_card.card_number
     *
     * @mbggenerated
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column treasure_card.card_number
     *
     * @param cardNumber the value for treasure_card.card_number
     *
     * @mbggenerated
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column treasure_card.card_password
     *
     * @return the value of treasure_card.card_password
     *
     * @mbggenerated
     */
    public String getCardPassword() {
        return cardPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column treasure_card.card_password
     *
     * @param cardPassword the value for treasure_card.card_password
     *
     * @mbggenerated
     */
    public void setCardPassword(String cardPassword) {
        this.cardPassword = cardPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column treasure_card.status
     *
     * @return the value of treasure_card.status
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column treasure_card.status
     *
     * @param status the value for treasure_card.status
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column treasure_card.item_type
     *
     * @return the value of treasure_card.item_type
     *
     * @mbggenerated
     */
    public Integer getItemType() {
        return itemType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column treasure_card.item_type
     *
     * @param itemType the value for treasure_card.item_type
     *
     * @mbggenerated
     */
    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column treasure_card.yn
     *
     * @return the value of treasure_card.yn
     *
     * @mbggenerated
     */
    public Integer getYn() {
        return yn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column treasure_card.yn
     *
     * @param yn the value for treasure_card.yn
     *
     * @mbggenerated
     */
    public void setYn(Integer yn) {
        this.yn = yn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column treasure_card.modified
     *
     * @return the value of treasure_card.modified
     *
     * @mbggenerated
     */
    public Date getModified() {
        return modified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column treasure_card.modified
     *
     * @param modified the value for treasure_card.modified
     *
     * @mbggenerated
     */
    public void setModified(Date modified) {
        this.modified = modified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column treasure_card.created
     *
     * @return the value of treasure_card.created
     *
     * @mbggenerated
     */
    public Date getCreated() {
        return created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column treasure_card.created
     *
     * @param created the value for treasure_card.created
     *
     * @mbggenerated
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }
}