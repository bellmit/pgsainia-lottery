package com.pgsainia.lottery.domain.award.service.goods.impl;

import com.pgsainia.lottery.common.Constants;
import com.pgsainia.lottery.domain.award.model.req.GoodsReq;
import com.pgsainia.lottery.domain.award.model.res.DistributionRes;
import com.pgsainia.lottery.domain.award.service.goods.DistributionBase;
import com.pgsainia.lottery.domain.award.service.goods.IDistributionGoods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @author nifujia
 * @date 2021/11/21 21:28
 * @description 优惠券商品
 */
@Component
public class CouponGoods extends DistributionBase implements IDistributionGoods {

    private final Logger logger = LoggerFactory.getLogger(CouponGoods.class);

    @Override
    public DistributionRes doDistribution(GoodsReq goodsReq) {
        logger.info("模拟优惠券发放接口，uId：{}，awardCount：{}", goodsReq.getuId(), goodsReq.getAwardContent());
        // 更新用户领奖结果
        super.updateUserAwardState(goodsReq.getuId(), goodsReq.getOrderId(), goodsReq.getAwardId(),
                Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());

        return new DistributionRes(goodsReq.getuId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());
    }
}