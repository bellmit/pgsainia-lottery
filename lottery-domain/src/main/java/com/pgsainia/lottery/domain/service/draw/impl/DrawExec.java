package com.pgsainia.lottery.domain.service.draw.impl;

import com.pgsainia.lottery.domain.model.aggregates.StrategyRich;
import com.pgsainia.lottery.domain.model.req.DrawReq;
import com.pgsainia.lottery.domain.model.res.DrawResult;
import com.pgsainia.lottery.domain.repository.impl.StrategyRepository;
import com.pgsainia.lottery.domain.service.algorithm.IDrawAlgorithm;
import com.pgsainia.lottery.domain.service.draw.DrawBase;
import com.pgsainia.lottery.domain.service.draw.IDrawExec;
import com.pgsainia.lottery.infrastructure.pojo.Award;
import com.pgsainia.lottery.infrastructure.pojo.Strategy;
import com.pgsainia.lottery.infrastructure.pojo.StrategyDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nifujia
 * @description
 * @date 2021/11/18
 */
@Service("drawExec")
public class DrawExec extends DrawBase implements IDrawExec {
    @Resource
    private StrategyRepository strategyRepository;

    private final Logger logger = LoggerFactory.getLogger(DrawExec.class);

    @Override
    public DrawResult doDrawExec(DrawReq drawReq) {
        logger.info("执行策略抽奖开始，strategyId：{}", drawReq.getStrategyId());
        // 查询抽奖策略
        StrategyRich strategyRich = strategyRepository.queryStrategyRich(drawReq.getStrategyId());
        Strategy strategy = strategyRich.getStrategy();
        List<StrategyDetail> strategyDetailList = strategyRich.getStrategyDetailList();

        // 校验并初始化数据
        checkAndInitRateData(drawReq.getStrategyId(), strategy.getStrategyMode(), strategyDetailList);

        // 根据策略模式抽奖
        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategy.getStrategyMode());
        String awardId = drawAlgorithm.randomDraw(drawReq.getStrategyId(), new ArrayList<>());

        // 获取奖品信息
        Award award = strategyRepository.queryAwardInfo(awardId);
        logger.info("执行策略抽奖完成，中奖用户：{}，奖品 id：{}， 奖品名称：{}", drawReq.getuId(), award.getAwardId(), award.getAwardName());
        return new DrawResult(drawReq.getuId(), drawReq.getStrategyId(), award.getAwardId(), award.getAwardName());
    }
}
