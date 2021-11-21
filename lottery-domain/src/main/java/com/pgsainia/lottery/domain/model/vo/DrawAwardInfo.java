package com.pgsainia.lottery.domain.model.vo;

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
     * 奖品名称
     */
    private String awardName;

    public DrawAwardInfo() {
    }

    public DrawAwardInfo(String awardId, String awardName) {
        this.awardId = awardId;
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
}