package com.pgsainia.lottery.domain.repository;

import com.pgsainia.lottery.domain.model.aggregates.StrategyRich;
import com.pgsainia.lottery.infrastructure.pojo.Award;

/**
 * @author nifujia
 * @description
 * @date 2021/11/17
 */
public interface IStrategyRepository {
    /**
     * 查询 strategyRick\h
     *
     * @param strategyId
     * @return
     */
    StrategyRich queryStrategyRich(Long strategyId);

    /**
     * 查询奖品信息
     *
     * @param awardId
     * @return
     */
    Award queryAwardInfo(String awardId);
}
