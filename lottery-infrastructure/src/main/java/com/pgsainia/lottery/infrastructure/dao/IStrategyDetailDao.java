package com.pgsainia.lottery.infrastructure.dao;

import com.pgsainia.lottery.infrastructure.pojo.StrategyDetail;

import java.util.List;

/**
 * @author nifujia
 * @description
 * @date 2021/11/17
 */
public interface IStrategyDetailDao {
    /**
     * 根据 strategyId 查询策略明细列表
     *
     * @param strategyId
     * @return
     */
    List<StrategyDetail> listStrategyDetail(Long strategyId);
}
