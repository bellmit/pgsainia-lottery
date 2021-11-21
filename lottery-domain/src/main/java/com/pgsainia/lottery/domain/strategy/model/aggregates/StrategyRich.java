package com.pgsainia.lottery.domain.strategy.model.aggregates;

import com.pgsainia.lottery.infrastructure.pojo.Strategy;
import com.pgsainia.lottery.infrastructure.pojo.StrategyDetail;

import java.util.List;

/**
 * @author nifujia
 * @description
 * @date 2021/11/17
 */
public class StrategyRich {

    /**
     * 策略 id
     */
    private Long strategyId;
    /**
     * 策略配置
     */
    private Strategy strategy;
    /**
     * 策略明细
     */
    List<StrategyDetail> strategyDetailList;

    public StrategyRich() {
    }

    public StrategyRich(Long strategyId, Strategy strategy, List<StrategyDetail> strategyDetailList) {
        this.strategyId = strategyId;
        this.strategy = strategy;
        this.strategyDetailList = strategyDetailList;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public List<StrategyDetail> getStrategyDetailList() {
        return strategyDetailList;
    }

    public void setStrategyDetailList(List<StrategyDetail> strategyDetailList) {
        this.strategyDetailList = strategyDetailList;
    }
}
