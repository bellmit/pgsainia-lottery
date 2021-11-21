package com.pgsainia.lottery.domain.service.draw;

import com.pgsainia.lottery.common.Constants;
import com.pgsainia.lottery.domain.service.algorithm.IDrawAlgorithm;
import com.pgsainia.lottery.domain.service.algorithm.impl.EntiretyRateRandomDrawAlgorithm;
import com.pgsainia.lottery.domain.service.algorithm.impl.SingleRateRandomDrawAlgorithm;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author nifujia
 * @description
 * @date 2021/11/18
 */
public class DrawConfig {

    @Resource
    private EntiretyRateRandomDrawAlgorithm entiretyRateRandomDrawAlgorithm;
    @Resource
    private SingleRateRandomDrawAlgorithm singleRateRandomDrawAlgorithm;

    protected static final Map<Integer, IDrawAlgorithm> drawAlgorithmGroup = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        drawAlgorithmGroup.put(Constants.StrategyMode.ENTIRETY.getCode(), entiretyRateRandomDrawAlgorithm);
        drawAlgorithmGroup.put(Constants.StrategyMode.SINGLE.getCode(), singleRateRandomDrawAlgorithm);
    }
}
