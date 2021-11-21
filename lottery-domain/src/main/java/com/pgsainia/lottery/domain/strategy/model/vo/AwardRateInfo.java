package com.pgsainia.lottery.domain.strategy.model.vo;

import java.math.BigDecimal;

/**
 * @author nifujia
 * @description
 * @date 2021/11/17
 */
public class AwardRateInfo {
    /**
     *  奖品 Id
     */
    private String awardId;
    /**
     * 中奖概率
     */
    private BigDecimal awardRate;

    public AwardRateInfo() {
    }

    public AwardRateInfo(String awardId, BigDecimal awardRate) {
        this.awardId = awardId;
        this.awardRate = awardRate;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public BigDecimal getAwardRate() {
        return awardRate;
    }

    public void setAwardRate(BigDecimal awardRate) {
        this.awardRate = awardRate;
    }
}
