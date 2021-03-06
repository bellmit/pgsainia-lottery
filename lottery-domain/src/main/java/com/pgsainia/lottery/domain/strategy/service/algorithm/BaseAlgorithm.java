package com.pgsainia.lottery.domain.strategy.service.algorithm;

import com.pgsainia.lottery.domain.strategy.model.vo.AwardRateInfo;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author nifujia
 * @description 公用的算法逻辑
 * @date 2021/11/18
 */
public abstract class BaseAlgorithm implements IDrawAlgorithm {

    /**
     * 斐波那契散列增量，逻辑：黄金分割点：(√5 - 1) / 2 = 0.6180339887，Math.pow(2, 32) * 0.6180339887 = 0x61c88647
     */
    private final int HASH_INCREMENT = 0x61c88647;

    /**
     * 数组初始化长度 128，保证数据填充时不发生碰撞的最小化初始值
     */
    private final int RATE_TUPLE_LENGTH = 128;

    /**
     * 存放概率与奖品对应的散列结果， strategyId->rateTuple
     */
    protected Map<Long, String[]> rateTupleMap = new ConcurrentHashMap<>();

    /**
     * 奖品区间概率 strategyId->[awardId->start, awardId->end]
     */
    protected Map<Long, List<AwardRateInfo>> awardRateInfoMap = new ConcurrentHashMap<>();

    @Override
    public void initRateTuple(Long strategyId, List<AwardRateInfo> awardRateInfoList) {
        // 保存奖品概率信息
        awardRateInfoMap.put(strategyId, awardRateInfoList);

        String[] rateTuple = rateTupleMap.computeIfAbsent(strategyId, key -> new String[RATE_TUPLE_LENGTH]);
        int cursorValue = 0;
        for (AwardRateInfo awardRateInfo : awardRateInfoList) {
            int rateValue = awardRateInfo.getAwardRate().multiply(new BigDecimal(100)).intValue();
            // 循环填充概率值
            for (int i = cursorValue + 1; i <= (cursorValue + rateValue); i++) {
                rateTuple[hashIndex(i)] = awardRateInfo.getAwardId();
            }
            cursorValue += rateValue;
        }

    }

    @Override
    public boolean isExistRateTuple(Long strategyId) {
        return this.rateTupleMap.containsKey(strategyId);
    }


    /**
     * 斐波那契散列算法，计算哈希索引下标值
     *
     * @param value
     * @return
     */
    protected int hashIndex(int value) {
        int hashcode = value * HASH_INCREMENT + HASH_INCREMENT;
        return hashcode & (RATE_TUPLE_LENGTH - 1);
    }

    /**
     * 生成百位随机抽奖码
     *
     * @param bound
     * @return
     */
    protected int generateSecureRandomIntCode(int bound) {
        return new SecureRandom().nextInt(bound) + 1;
    }
}
