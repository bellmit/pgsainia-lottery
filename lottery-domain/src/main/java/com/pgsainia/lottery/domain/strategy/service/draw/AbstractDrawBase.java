package com.pgsainia.lottery.domain.strategy.service.draw;

import com.pgsainia.lottery.common.Constants;
import com.pgsainia.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.pgsainia.lottery.domain.strategy.model.req.DrawReq;
import com.pgsainia.lottery.domain.strategy.model.res.DrawResult;
import com.pgsainia.lottery.domain.strategy.model.vo.AwardRateInfo;
import com.pgsainia.lottery.domain.strategy.model.vo.DrawAwardInfo;
import com.pgsainia.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import com.pgsainia.lottery.infrastructure.pojo.Award;
import com.pgsainia.lottery.infrastructure.pojo.StrategyDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nifujia
 * @description
 * @date 2021/11/18
 */
public abstract class AbstractDrawBase extends DrawStrategySupport implements IDrawExec {

    private final Logger logger = LoggerFactory.getLogger(AbstractDrawBase.class);

    @Override
    public DrawResult doDrawExec(DrawReq drawReq) {
        // 1、获取抽奖策略
        StrategyRich strategyRich = this.queryStrategyRich(drawReq.getStrategyId());

        // 2、检查抽奖策略是否已经初始化到内存
        this.checkAndInitRateData(drawReq.getStrategyId(), strategyRich.getStrategy().getStrategyMode(),
                strategyRich.getStrategyDetailList());

        // 3、抽取不在抽奖范围内的列表，包括：奖品列表为空，风控策略，临时调整等等
        List<String> excludeAwardIds = this.queryExcludeAwardIds(strategyRich.getStrategyId());

        // 4、执行抽奖算法
        String awardId = this.drawAlgorithm(strategyRich.getStrategyId(), drawAlgorithmGroup.get(strategyRich.getStrategy().getStrategyMode()),
                excludeAwardIds);

        // 5、包装中奖结果
        return buildAwardResult(drawReq.getuId(), drawReq.getStrategyId(), awardId);
    }

    /**
     * 获取不在抽奖范围内的列表，包括：奖品库存为空，风控策略，临时调整，这类数据是含有业务逻辑的，所以需要由具体的实现方来实现
     *
     * @param strategyId
     * @return
     */
    public abstract List<String> queryExcludeAwardIds(Long strategyId);

    /**
     * 包装抽奖结果
     *
     * @param uId
     * @param strategyId
     * @param awardId
     * @return
     */
    private DrawResult buildAwardResult(String uId, Long strategyId, String awardId) {
        if (awardId == null) {
            logger.info("执行策略抽奖完成「未中奖」，用户 Id：{}，策略 Id：{}", uId, strategyId);
            return new DrawResult(uId, strategyId, Constants.DrawState.FAIL.getCode());
        }
        Award award = this.queryAwardInfoByAwardId(awardId);
        DrawAwardInfo drawAwardInfo = new DrawAwardInfo(awardId, award.getAwardType(), award.getAwardContent(), award.getAwardName());
        logger.info("执行策略抽奖完成「已中奖」，用户 Id：{}，策略 Id：{}，奖品 Id：{}，奖品名称：{}",
                uId, strategyId, drawAwardInfo.getAwardId(), drawAwardInfo.getAwardName());
        return new DrawResult(uId, strategyId, Constants.DrawState.SUCCESS.getCode(), drawAwardInfo);
    }

    /**
     * 执行抽奖算法
     *
     * @param strategyId      策略 id
     * @param drawAlgorithm   抽奖算法
     * @param excludeAwardIds 排除抽奖Id 集合
     * @return 奖品 id
     */
    public abstract String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<String> excludeAwardIds);

    /**
     * 检查抽奖策略是否已经初始化到内存
     *
     * @param strategyId
     * @param strategyMode
     * @param strategyDetailList
     */
    public void checkAndInitRateData(Long strategyId, Integer strategyMode, List<StrategyDetail> strategyDetailList) {
        // 非单项概率不用存入缓存
        if (!Constants.StrategyMode.SINGLE.getCode().equals(strategyMode)) return;
        IDrawAlgorithm drawAlgorithm = drawAlgorithmGroup.get(strategyMode);
        // 已经初始化过的，不用再重新初始化
        boolean existRateTuple = drawAlgorithm.isExistRateTuple(strategyId);
        if (existRateTuple) return;
        // 解析并初始化中奖概率到散列表
        List<AwardRateInfo> awardRateInfoList = new ArrayList<>();
        for (StrategyDetail strategyDetail : strategyDetailList) {
            awardRateInfoList.add(new AwardRateInfo(strategyDetail.getAwardId(), strategyDetail.getAwardRate()));
        }
        drawAlgorithm.initRateTuple(strategyId, awardRateInfoList);
    }
}
