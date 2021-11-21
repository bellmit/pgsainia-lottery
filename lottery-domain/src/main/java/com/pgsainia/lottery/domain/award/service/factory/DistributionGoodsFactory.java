package com.pgsainia.lottery.domain.award.service.factory;

import com.pgsainia.lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Component;

/**
 * @author nifujia
 * @date 2021/11/21 21:53
 * @description 配送商品简单工厂，提供获取配送服务
 */
@Component
public class DistributionGoodsFactory extends GoodsConfig {

    public IDistributionGoods getDistributeGoodsService(Integer awardType) {
        return super.goodsMap.get(awardType);
    }
}