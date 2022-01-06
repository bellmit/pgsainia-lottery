package com.pgsainia.lottery.domain.activity.repository;

import com.pgsainia.lottery.domain.activity.model.vo.ActivityVO;
import com.pgsainia.lottery.domain.activity.model.vo.AwardVO;
import com.pgsainia.lottery.domain.activity.model.vo.StrategyDetailVO;
import com.pgsainia.lottery.domain.activity.model.vo.StrategyVO;

import java.util.List;

/**
 * @author nifujia
 * @description
 * @date 2021/11/24
 */
public interface IActivityRepository {
    /**
     * 添加活动信息配置
     *
     * @param activity
     */
    void addActivity(ActivityVO activity);

    /**
     * 添加策略配置
     *
     * @param strategy
     */
    void addStrategy(StrategyVO strategy);

    /**
     * 添加策略配置明细
     *
     * @param strategyDetailList
     */
    void addStrategyDetailList(List<StrategyDetailVO> strategyDetailList);

    /**
     * 添加奖品配置集合
     *
     * @param awardList
     */
    void addAward(List<AwardVO> awardList);

    /**
     * 修改活动状态
     *
     * @param activityId   活动 id
     * @param beforeStatus 修改前状态
     * @param afterStatus  修改后状态
     * @return
     */
    boolean alterStatus(Long activityId, Integer beforeStatus, Integer afterStatus);

}
