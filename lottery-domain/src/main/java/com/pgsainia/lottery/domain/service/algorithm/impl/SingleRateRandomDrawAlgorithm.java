package com.pgsainia.lottery.domain.service.algorithm.impl;

import com.pgsainia.lottery.domain.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.List;

/**
 * @author nifujia
 * @description 单机随机抽奖，抽到一个已经排到的奖品，则未中奖（推荐使用 ）
 * @date 2021/11/18
 */
@Component("singleRateRandomDrawAlgorithm")
public class SingleRateRandomDrawAlgorithm extends BaseAlgorithm {
    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {
        // 获取策略对应的元祖
        String[] rateTuple = super.rateTupleMap.get(strategyId);
        assert rateTuple != null;

        // 随机索引
        int randomValue = super.generateSecureRandomIntCode(100);
        int index = super.hashIndex(randomValue);
        String awardId = rateTuple[index];
        if (excludeAwardIds.contains(awardId)) return null;
        return awardId;
    }
}
