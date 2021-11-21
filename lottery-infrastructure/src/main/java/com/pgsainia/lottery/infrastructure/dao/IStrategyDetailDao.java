package com.pgsainia.lottery.infrastructure.dao;

import com.pgsainia.lottery.infrastructure.pojo.StrategyDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author nifujia
 * @description
 * @date 2021/11/17
 */
@Mapper
public interface IStrategyDetailDao {
    /**
     * 根据 strategyId 查询策略明细列表
     *
     * @param strategyId
     * @return
     */
    List<StrategyDetail> listStrategyDetail(Long strategyId);

    /**
     * 查询无库存策略奖品 Id
     *
     * @param strategyId
     * @return
     */
    List<String> listNoStockStrategyAwardList(Long strategyId);

    /**
     * 扣减库存
     *
     * @param strategyDetail
     * @return
     */
    int deductStock(StrategyDetail strategyDetail);
}
