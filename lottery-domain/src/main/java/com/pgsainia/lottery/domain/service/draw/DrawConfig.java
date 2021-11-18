package com.pgsainia.lottery.domain.service.draw;

import com.pgsainia.lottery.domain.service.algorithm.IDrawAlgorithm;
import com.pgsainia.lottery.domain.service.algorithm.impl.DefaultRateRandomDrawAlgorithm;
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
    private DefaultRateRandomDrawAlgorithm defaultRateRandomDrawAlgorithm;
    @Resource
    private SingleRateRandomDrawAlgorithm singleRateRandomDrawAlgorithm;

    protected static final Map<Integer, IDrawAlgorithm> drawAlgorithmMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        drawAlgorithmMap.put(1, defaultRateRandomDrawAlgorithm);
        drawAlgorithmMap.put(2, singleRateRandomDrawAlgorithm);
    }
}
