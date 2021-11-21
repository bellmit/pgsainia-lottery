package com.pgsainia.lottery.domain.strategy.model.req;

/**
 * @author nifujia
 * @description
 * @date 2021/11/17
 */
public class DrawReq {
    /**
     * 用户 id
     */
    private String uId;
    /**
     * 策略 id
     */
    private Long strategyId;

    public DrawReq() {
    }

    public DrawReq(String uId, Long strategyId) {
        this.uId = uId;
        this.strategyId = strategyId;
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
}
