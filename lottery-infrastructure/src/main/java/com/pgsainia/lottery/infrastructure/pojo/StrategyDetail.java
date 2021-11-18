package com.pgsainia.lottery.infrastructure.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author nifujia
 * @description
 * @date 2021/11/17
 */
public class StrategyDetail {
    /**
     * 自增 id
     */
    private Long id;
    /**
     * 策略 id
     */
    private Long strategyId;
    /**
     * 奖品 id
     */
    private String awardId;
    /**
     * 奖品数量
     */
    private Integer awardCount;
    /**
     * 中奖概率
     */
    private BigDecimal awardRate;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getAwardCount() {
        return awardCount;
    }

    public void setAwardCount(Integer awardCount) {
        this.awardCount = awardCount;
    }

    public BigDecimal getAwardRate() {
        return awardRate;
    }

    public void setAwardRate(BigDecimal awardRate) {
        this.awardRate = awardRate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
