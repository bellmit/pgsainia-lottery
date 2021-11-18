package com.pgsainia.lottery.domain.repository.impl;

import com.pgsainia.lottery.domain.model.aggregates.StrategyRich;
import com.pgsainia.lottery.domain.repository.IStrategyRepository;
import com.pgsainia.lottery.infrastructure.dao.IAwardDao;
import com.pgsainia.lottery.infrastructure.dao.IStrategyDao;
import com.pgsainia.lottery.infrastructure.dao.IStrategyDetailDao;
import com.pgsainia.lottery.infrastructure.pojo.Award;
import com.pgsainia.lottery.infrastructure.pojo.Strategy;
import com.pgsainia.lottery.infrastructure.pojo.StrategyDetail;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author nifujia
 * @description
 * @date 2021/11/17
 */
@Component
public class StrategyRepository implements IStrategyRepository {

    @Resource
    private IStrategyDao strategyDao;
    @Resource
    private IStrategyDetailDao strategyDetailDao;
    @Resource
    private IAwardDao awardDao;

    @Override
    public StrategyRich queryStrategyRich(Long strategyId) {
        Strategy strategy = strategyDao.queryStrategy(strategyId);
        List<StrategyDetail> strategyDetailList = strategyDetailDao.listStrategyDetail(strategyId);
        return new StrategyRich(strategyId, strategy, strategyDetailList);
    }

    @Override
    public Award queryAwardInfo(String awardId) {
        return awardDao.queryAwardInfo(awardId);
    }
}
