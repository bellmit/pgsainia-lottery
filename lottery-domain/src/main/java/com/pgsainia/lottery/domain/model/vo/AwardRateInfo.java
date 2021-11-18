package com.pgsainia.lottery.domain.model.vo;

import java.math.BigDecimal;

/**
 * @author nifujia
 * @description
 * @date 2021/11/17
 */
public class AwardRateInfo {
    private String awardId;
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
