package com.pgsainia.lottery.domain.strategy.model.vo;

/**
 * @author nifujia
 * @date 2021/11/21 11:42
 * @description
 */
public class DrawAwardInfo {
    /**
     * 奖品 id
     */
    private String awardId;

    /**
     * 奖品类型 1-文字描述，2-兑换码，3-优惠券，4-实物商品
     */
    private Integer awardType;

    /**
     *奖品内容，文字描述，兑奖码，sku
     */
    private String awardContent;
    /**
     * 奖品名称
     */
    private String awardName;

    public DrawAwardInfo() {
    }

    public DrawAwardInfo(String awardId, Integer awardType, String awardContent, String awardName) {
        this.awardId = awardId;
        this.awardType = awardType;
        this.awardContent = awardContent;
        this.awardName = awardName;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public Integer getAwardType() {
        return awardType;
    }

    public void setAwardType(Integer awardType) {
        this.awardType = awardType;
    }

    public String getAwardContent() {
        return awardContent;
    }

    public void setAwardContent(String awardContent) {
        this.awardContent = awardContent;
    }
}