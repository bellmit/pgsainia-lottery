package com.pgsainia.lottery.infrastructure.dao;

import com.pgsainia.lottery.infrastructure.pojo.Strategy;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author nifujia
 * @description
 * @date 2021/11/17
 */
@Mapper
public interface IStrategyDao {
    /**
     * 根据 strategyId 查询抽奖策略信息
     *
     * @param strategyId
     * @return
     */
    Strategy queryStrategy(Long strategyId);

    /**
     * 保存策略信息
     *
     * @param strategy
     */
    void insert(Strategy strategy);
}
