package com.pgsainia.lottery.domain.award.service.factory;

import com.pgsainia.lottery.common.Constants;
import com.pgsainia.lottery.domain.award.service.goods.IDistributionGoods;
import com.pgsainia.lottery.domain.award.service.goods.impl.CouponGoods;
import com.pgsainia.lottery.domain.award.service.goods.impl.DescGoods;
import com.pgsainia.lottery.domain.award.service.goods.impl.PhysicalGoods;
import com.pgsainia.lottery.domain.award.service.goods.impl.RedeemCodeGoods;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author nifujia
 * @date 2021/11/21 21:44
 * @description
 */
public class GoodsConfig {
    /**
     * 奖品发放策略组
     */
    protected final Map<Integer, IDistributionGoods> goodsMap = new ConcurrentHashMap<>();

    @Resource
    private DescGoods descGoods;
    @Resource
    private RedeemCodeGoods redeemCodeGoods;
    @Resource
    private CouponGoods couponGoods;
    @Resource
    private PhysicalGoods physicalGoods;

    @PostConstruct
    public void init() {
        goodsMap.put(Constants.AwardType.DESC.getCode(), descGoods);
        goodsMap.put(Constants.AwardType.REDEEM_CODE_GOODS.getCode(), redeemCodeGoods);
        goodsMap.put(Constants.AwardType.COUPON_GOODS.getCode(), couponGoods);
        goodsMap.put(Constants.AwardType.PHYSICAL_GOODS.getCode(), physicalGoods);
    }
}