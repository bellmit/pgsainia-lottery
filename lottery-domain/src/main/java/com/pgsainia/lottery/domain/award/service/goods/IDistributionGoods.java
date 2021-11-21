package com.pgsainia.lottery.domain.award.service.goods;

import com.pgsainia.lottery.domain.award.model.req.GoodsReq;
import com.pgsainia.lottery.domain.award.model.res.DistributionRes;

/**
 * @author nifujia
 * @date 2021/11/21 21:19
 * @description 抽奖，用于抽象出配送货物接口，把各类奖品模拟成货物，配送代表着发货，包括虚拟商品和实物商品
 */
public interface IDistributionGoods {

    /**
     * 奖品配送接口，奖品类型（1：文字描述，2：兑奖码，3：优惠券，4：实物商品）
     *
     * @param goodsReq
     * @return
     */
    DistributionRes doDistribution(GoodsReq goodsReq);
}