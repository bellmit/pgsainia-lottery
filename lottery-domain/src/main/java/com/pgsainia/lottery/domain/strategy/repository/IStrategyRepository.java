package com.pgsainia.lottery.domain.strategy.repository;

import com.pgsainia.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.pgsainia.lottery.infrastructure.pojo.Award;

import java.util.List;

/**
 * @author nifujia
 * @description
 * @date 2021/11/17
 */
public interface IStrategyRepository {
    /**
     * 查询 strategyRich
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

    /**
     * 查询没有库存的策略奖品 Id
     *
     * @param strategyId
     * @return
     */
    List<String> listNoStockStrategyAwardList(Long strategyId);

    /**
     * 扣减库存
     *
     * @param strategyId
     * @param awardId
     * @return
     */
    boolean deductStock(Long strategyId, String awardId);
}
