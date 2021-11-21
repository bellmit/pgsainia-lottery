package com.pgsainia.lottery.domain.strategy.service.draw;

import com.pgsainia.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.pgsainia.lottery.domain.strategy.repository.IStrategyRepository;
import com.pgsainia.lottery.infrastructure.pojo.Award;

import javax.annotation.Resource;

/**
 * @author nifujia
 * @date 2021/11/21 11:15
 * @description
 */
public class DrawStrategySupport extends DrawConfig {

    @Resource
    protected IStrategyRepository strategyRepository;

    /**
     * 查询策略配置信息
     *
     * @param strategyId
     * @return
     */
    protected StrategyRich queryStrategyRich(Long strategyId) {
        return strategyRepository.queryStrategyRich(strategyId);
    }

    /**
     * 通过 awardId 查询奖品信息
     *
     * @param awardId
     * @return
     */
    protected Award queryAwardInfoByAwardId(String awardId) {
        return strategyRepository.queryAwardInfo(awardId);
    }

}