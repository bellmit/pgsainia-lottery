package com.pgsainia.lottery.domain.activity.service.deploy.impl;

import com.alibaba.fastjson.JSON;
import com.pgsainia.lottery.domain.activity.model.aggregates.ActivityConfigRich;
import com.pgsainia.lottery.domain.activity.model.req.ActivityConfigReq;
import com.pgsainia.lottery.domain.activity.repository.IActivityRepository;
import com.pgsainia.lottery.domain.activity.service.deploy.IActivityDeploy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author nifujia
 * @description
 * @date 2022/1/6
 */
@Service
public class ActivityDeploy implements IActivityDeploy {

    private final Logger logger = LoggerFactory.getLogger(ActivityDeploy.class);

    @Resource
    private IActivityRepository activityRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createActivity(ActivityConfigReq activityConfigReq) {
        logger.info("创建活动配置开始， 活动id：{}", activityConfigReq.getActivityId());
        ActivityConfigRich activityConfigRich = activityConfigReq.getActivityConfigRich();
        try {
            // 1、添加活动配置
            activityRepository.addActivity(activityConfigRich.getActivity());
            // 2、添加奖品配置
            activityRepository.addAward(activityConfigRich.getAwardList());
            // 3、添加策略配置
            activityRepository.addStrategy(activityConfigRich.getStrategy());
            // 4、添加策略明细配置
            activityRepository.addStrategyDetailList(activityConfigRich.getStrategy().getStrategyDetailList());

            logger.info("创建活动配置完成，活动id：{}", activityConfigReq.getActivityId());
        } catch (Exception e) {
            logger.error("创建活动配置失败，活动id：{}，参数：{}", activityConfigReq.getActivityId(), JSON.toJSONString(activityConfigReq), e);
            throw e;
        }
    }

    @Override
    public void updateActivity(ActivityConfigReq activityConfigReq) {

    }
}
