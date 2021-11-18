package com.pgsainia.lottery.domain.service.draw;

import com.pgsainia.lottery.domain.model.vo.AwardRateInfo;
import com.pgsainia.lottery.domain.service.algorithm.IDrawAlgorithm;
import com.pgsainia.lottery.infrastructure.pojo.StrategyDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nifujia
 * @description
 * @date 2021/11/18
 */
public class DrawBase extends DrawConfig {

    public void checkAndInitRateData(Long strategyId, Integer strategyMode, List<StrategyDetail> strategyDetailList) {
        if (1 != strategyMode) return;
        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategyMode);
        boolean existRateTuple = drawAlgorithm.isExistRateTuple(strategyId);
        if (existRateTuple) return;

        List<AwardRateInfo> awardRateInfoList = new ArrayList<>();
        for (StrategyDetail strategyDetail : strategyDetailList) {
            awardRateInfoList.add(new AwardRateInfo(strategyDetail.getAwardId(), strategyDetail.getAwardRate()));
        }
        drawAlgorithm.initRateTuple(strategyId, awardRateInfoList);
    }

}
