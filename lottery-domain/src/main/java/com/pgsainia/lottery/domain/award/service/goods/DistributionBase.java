package com.pgsainia.lottery.domain.award.service.goods;

import com.pgsainia.lottery.domain.award.repository.IAwardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @author nifujia
 * @date 2021/11/21 21:22
 * @description 配送货物基础公用类
 */
public class DistributionBase {
    private final Logger logger = LoggerFactory.getLogger(DistributionBase.class);
    @Resource
    private IAwardRepository awardRepository;

    /**
     * 用户个人的抽奖记录表中奖品发奖状态
     *
     * @param uId
     * @param orderId
     * @param awardId
     * @param awardState
     * @param awardStateInfo
     */
    protected void updateUserAwardState(String uId, String orderId, String awardId, Integer awardState, String awardStateInfo) {
        logger.info("后期添加分库分表中，用户个人的抽奖记录中奖品发放状态，uId：{}", uId);
    }

}