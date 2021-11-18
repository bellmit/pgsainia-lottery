package com.pgsainia.lottery.domain.model.res;

/**
 * @author nifujia
 * @description
 * @date 2021/11/17
 */
public class DrawResult {
    /**
     * 用户 id
     */
    private String uId;
    /**
     * 策略 id
     */
    private Long strategyId;
    /**
     * 奖品 id
     */
    private String awardId;
    /**
     * 奖品名称
     */
    private String awardName;

    public DrawResult() {
    }

    public DrawResult(String uId, Long strategyId, String awardId, String awardName) {
        this.uId = uId;
        this.strategyId = strategyId;
        this.awardId = awardId;
        this.awardName = awardName;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
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
