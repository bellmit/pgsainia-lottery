package com.pgsainia.lottery.domain.strategy.model.aggregates;

import com.pgsainia.lottery.domain.strategy.model.vo.StrategyBriefVO;
import com.pgsainia.lottery.domain.strategy.model.vo.StrategyDetailBriefVO;

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
    private StrategyBriefVO strategy;
    /**
     * 策略明细
     */
    List<StrategyDetailBriefVO> strategyDetailList;

    public StrategyRich() {
    }

    public StrategyRich(Long strategyId, StrategyBriefVO strategy, List<StrategyDetailBriefVO> strategyDetailList) {
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

    public StrategyBriefVO getStrategy() {
        return strategy;
    }

    public void setStrategy(StrategyBriefVO strategy) {
        this.strategy = strategy;
    }

    public List<StrategyDetailBriefVO> getStrategyDetailList() {
        return strategyDetailList;
    }

    public void setStrategyDetailList(List<StrategyDetailBriefVO> strategyDetailList) {
        this.strategyDetailList = strategyDetailList;
    }
}
