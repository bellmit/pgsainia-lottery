package com.pgsainia.lottery.test;

import com.alibaba.fastjson.JSON;
import com.pgsainia.lottery.common.Constants;
import com.pgsainia.lottery.domain.award.model.req.GoodsReq;
import com.pgsainia.lottery.domain.award.model.res.DistributionRes;
import com.pgsainia.lottery.domain.award.service.factory.DistributionGoodsFactory;
import com.pgsainia.lottery.domain.award.service.goods.IDistributionGoods;
import com.pgsainia.lottery.domain.strategy.model.req.DrawReq;
import com.pgsainia.lottery.domain.strategy.model.res.DrawResult;
import com.pgsainia.lottery.domain.strategy.model.vo.DrawAwardInfo;
import com.pgsainia.lottery.domain.strategy.service.draw.IDrawExec;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

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

        DrawResult drawResult = drawExec.doDrawExec(new DrawReq("小明", 10001L));
        if (drawResult.getDrawState().equals(Constants.DrawState.FAIL.getCode())) {
            logger.info("未中奖。。。");
            return;
        }

        DrawAwardInfo drawAwardInfo = drawResult.getDrawAwardInfo();

        IDistributionGoods distributeGoodsService = distributionGoodsFactory.getDistributeGoodsService(drawAwardInfo.getAwardType());
        GoodsReq goodsReq = new GoodsReq(drawResult.getuId(), "order-001", drawAwardInfo.getAwardId(),
                drawAwardInfo.getAwardName(), drawAwardInfo.getAwardContent());
        DistributionRes distributionRes = distributeGoodsService.doDistribution(goodsReq);

        logger.info("测试结果：{}", JSON.toJSONString(distributionRes));
    }
}
