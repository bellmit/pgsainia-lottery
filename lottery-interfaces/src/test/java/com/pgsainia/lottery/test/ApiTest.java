package com.pgsainia.lottery.test;

import com.alibaba.fastjson.JSON;
import com.pgsainia.lottery.common.Constants;
import com.pgsainia.lottery.domain.activity.model.aggregates.ActivityConfigRich;
import com.pgsainia.lottery.domain.activity.model.req.ActivityConfigReq;
import com.pgsainia.lottery.domain.activity.model.vo.ActivityVO;
import com.pgsainia.lottery.domain.activity.model.vo.AwardVO;
import com.pgsainia.lottery.domain.activity.model.vo.StrategyDetailVO;
import com.pgsainia.lottery.domain.activity.model.vo.StrategyVO;
import com.pgsainia.lottery.domain.activity.service.deploy.impl.ActivityDeploy;
import com.pgsainia.lottery.domain.activity.service.stateflow.IStateHandler;
import com.pgsainia.lottery.domain.award.model.req.GoodsReq;
import com.pgsainia.lottery.domain.award.model.res.DistributionRes;
import com.pgsainia.lottery.domain.award.service.factory.DistributionGoodsFactory;
import com.pgsainia.lottery.domain.award.service.goods.IDistributionGoods;
import com.pgsainia.lottery.domain.strategy.model.req.DrawReq;
import com.pgsainia.lottery.domain.strategy.model.res.DrawResult;
import com.pgsainia.lottery.domain.strategy.model.vo.DrawAwardInfo;
import com.pgsainia.lottery.domain.strategy.service.draw.IDrawExec;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author nifujia
 * @description
 * @date 2021/11/15
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Resource
    private IDrawExec drawExec;
    @Resource
    private DistributionGoodsFactory distributionGoodsFactory;

    @Test
    public void testAward() {

        DrawResult drawResult = drawExec.doDrawExec(new DrawReq("??????", 10001L));
        if (drawResult.getDrawState().equals(Constants.DrawState.FAIL.getCode())) {
            logger.info("??????????????????");
            return;
        }

        DrawAwardInfo drawAwardInfo = drawResult.getDrawAwardInfo();

        IDistributionGoods distributeGoodsService = distributionGoodsFactory.getDistributeGoodsService(drawAwardInfo.getAwardType());
        GoodsReq goodsReq = new GoodsReq(drawResult.getuId(), "order-001", drawAwardInfo.getAwardId(),
                drawAwardInfo.getAwardName(), drawAwardInfo.getAwardContent());
        DistributionRes distributionRes = distributeGoodsService.doDistribution(goodsReq);

        logger.info("???????????????{}", JSON.toJSONString(distributionRes));
    }

    /**
     * TODO???????????????ID????????????
     */
    private Long activityId = 120981321L;

    @Resource
    private ActivityDeploy activityDeploy;

    @Resource
    private IStateHandler stateHandler;

    ActivityConfigRich activityConfigRich;

    @Before
    public void init() {

        ActivityVO activity = new ActivityVO();
        activity.setActivityId(activityId);
        activity.setActivityName("????????????");
        activity.setActivityDesc("??????????????????");
        activity.setBeginDateTime(new Date());
        activity.setEndDateTime(new Date());
        activity.setStockCount(100);
        activity.setTackCount(10);
        activity.setState(Constants.ActivityState.EDIT.getCode());
        activity.setCreator("nini");

        StrategyVO strategy = new StrategyVO();
        strategy.setStrategyId(10002L);
        strategy.setStrategyDesc("????????????");
        strategy.setStrategyMode(Constants.StrategyMode.SINGLE.getCode());
        strategy.setGrantType(1);
        strategy.setGrantDate(new Date());
        strategy.setExtInfo("");

        StrategyDetailVO strategyDetail_01 = new StrategyDetailVO();
        strategyDetail_01.setStrategyId(strategy.getStrategyId());
        strategyDetail_01.setAwardId("101");
        strategyDetail_01.setAwardName("?????????");
        strategyDetail_01.setAwardCount(10);
        strategyDetail_01.setAwardSurplusCount(10);
        strategyDetail_01.setAwardRate(new BigDecimal("0.05"));

        StrategyDetailVO strategyDetail_02 = new StrategyDetailVO();
        strategyDetail_02.setStrategyId(strategy.getStrategyId());
        strategyDetail_02.setAwardId("102");
        strategyDetail_02.setAwardName("?????????");
        strategyDetail_02.setAwardCount(20);
        strategyDetail_02.setAwardSurplusCount(20);
        strategyDetail_02.setAwardRate(new BigDecimal("0.15"));

        StrategyDetailVO strategyDetail_03 = new StrategyDetailVO();
        strategyDetail_03.setStrategyId(strategy.getStrategyId());
        strategyDetail_03.setAwardId("103");
        strategyDetail_03.setAwardName("?????????");
        strategyDetail_03.setAwardCount(50);
        strategyDetail_03.setAwardSurplusCount(50);
        strategyDetail_03.setAwardRate(new BigDecimal("0.20"));

        StrategyDetailVO strategyDetail_04 = new StrategyDetailVO();
        strategyDetail_04.setStrategyId(strategy.getStrategyId());
        strategyDetail_04.setAwardId("104");
        strategyDetail_04.setAwardName("?????????");
        strategyDetail_04.setAwardCount(100);
        strategyDetail_04.setAwardSurplusCount(100);
        strategyDetail_04.setAwardRate(new BigDecimal("0.25"));

        StrategyDetailVO strategyDetail_05 = new StrategyDetailVO();
        strategyDetail_05.setStrategyId(strategy.getStrategyId());
        strategyDetail_05.setAwardId("104");
        strategyDetail_05.setAwardName("?????????");
        strategyDetail_05.setAwardCount(500);
        strategyDetail_05.setAwardSurplusCount(500);
        strategyDetail_05.setAwardRate(new BigDecimal("0.35"));

        List<StrategyDetailVO> strategyDetailList = new ArrayList<>();
        strategyDetailList.add(strategyDetail_01);
        strategyDetailList.add(strategyDetail_02);
        strategyDetailList.add(strategyDetail_03);
        strategyDetailList.add(strategyDetail_04);
        strategyDetailList.add(strategyDetail_05);

        strategy.setStrategyDetailList(strategyDetailList);

        AwardVO award_01 = new AwardVO();
        award_01.setAwardId("101");
        award_01.setAwardType(Constants.AwardType.DESC.getCode());
        award_01.setAwardName("??????");
        award_01.setAwardContent("???????????????????????? nini");

        AwardVO award_02 = new AwardVO();
        award_02.setAwardId("102");
        award_02.setAwardType(Constants.AwardType.DESC.getCode());
        award_02.setAwardName("??????");
        award_02.setAwardContent("???????????????????????? nini");

        AwardVO award_03 = new AwardVO();
        award_03.setAwardId("103");
        award_03.setAwardType(Constants.AwardType.DESC.getCode());
        award_03.setAwardName("??????");
        award_03.setAwardContent("???????????????????????? nini");

        AwardVO award_04 = new AwardVO();
        award_04.setAwardId("104");
        award_04.setAwardType(Constants.AwardType.DESC.getCode());
        award_04.setAwardName("??????");
        award_04.setAwardContent("???????????????????????? nini");

        AwardVO award_05 = new AwardVO();
        award_05.setAwardId("105");
        award_05.setAwardType(Constants.AwardType.DESC.getCode());
        award_05.setAwardName("?????????");
        award_05.setAwardContent("???????????????????????? nini");

        List<AwardVO> awardList = new ArrayList<>();
        awardList.add(award_01);
        awardList.add(award_02);
        awardList.add(award_03);
        awardList.add(award_04);
        awardList.add(award_05);
        activityConfigRich = new ActivityConfigRich(activity, strategy, awardList);
    }

    @Test
    public void testCreateActivity() {
        activityDeploy.createActivity(new ActivityConfigReq(activityId, activityConfigRich));
    }

    @Test
    public void testAlterStatus() {
        logger.info("???????????????{}", JSON.toJSONString(stateHandler.arraignment(100001L, Constants.ActivityState.EDIT)));
        logger.info("???????????????{}", JSON.toJSONString(stateHandler.checkPass(100001L, Constants.ActivityState.ARRAIGNMENT)));
        logger.info("???????????????{}", JSON.toJSONString(stateHandler.doing(100001L, Constants.ActivityState.PASS)));
        logger.info("???????????????{}", JSON.toJSONString(stateHandler.checkPass(100001L, Constants.ActivityState.EDIT)));
    }

}
