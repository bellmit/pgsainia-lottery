package com.pgsainia.lottery.domain.strategy.service.algorithm.impl;

import com.pgsainia.lottery.domain.strategy.model.vo.AwardRateInfo;
import com.pgsainia.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nifujia
 * @description 必中策略抽奖，排除已经中奖的概率，重新计算抽奖概率
 * @date 2021/11/18
 */
@Component("entiretyRateRandomDrawAlgorithm")
public class EntiretyRateRandomDrawAlgorithm extends BaseAlgorithm {
    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {

        // 排除不在范围内的奖品 id 集合
        BigDecimal differenceDenominator = BigDecimal.ZERO;
        List<AwardRateInfo> differenceAwardRateList = new ArrayList<>();
        List<AwardRateInfo> awardRateIntervalValueList = super.awardRateInfoMap.get(strategyId);
        for (AwardRateInfo awardRateInfo : awardRateIntervalValueList) {
            String awardId = awardRateInfo.getAwardId();
            if (excludeAwardIds.contains(awardId)) continue;

            differenceAwardRateList.add(awardRateInfo);
            differenceDenominator = differenceDenominator.add(awardRateInfo.getAwardRate());
        }

        // 前置判断
        if (differenceAwardRateList.size() == 0) return null;
        if (differenceAwardRateList.size() == 1) return differenceAwardRateList.get(0).getAwardId();

        // 获取随机概率值
        int randomValue = super.generateSecureRandomIntCode(100);

        // 循环获取奖品
        String awardId = null;
        int cursorValue = 0;
        for (AwardRateInfo awardRateInfo : differenceAwardRateList) {
            int rateValue = awardRateInfo.getAwardRate().divide(differenceDenominator, 1, BigDecimal.ROUND_UP)
                    .multiply(new BigDecimal(100)).intValue();
            if (randomValue <= (cursorValue + rateValue)) {
                awardId = awardRateInfo.getAwardId();
                break;
            }
            cursorValue += rateValue;
        }
        return awardId;
    }
}
