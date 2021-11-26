package com.pgsainia.lottery.domain.activity.model.vo;

/**
 * @author nifujia
 * @description 奖品信息配置
 * @date 2021/11/23
 */
public class AwardVO {
    /**
     * 奖品 Id
     */
    private String awardId;
    /**
     * 奖品名称
     */
    private String awardName;
    /**
     * 奖品类型，1-文字描述，2-兑奖码，3-优惠券，4-实物商品
     */
    private Integer awardType;
    /**
     * 奖品内容
     */
    private String awardContent;

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

    @Override
    public String toString() {
        return "AwardBriefVO{" +
                "awardId='" + awardId + '\'' +
                ", awardName='" + awardName + '\'' +
                ", awardType=" + awardType +
                ", awardContent='" + awardContent + '\'' +
                '}';
    }
}
