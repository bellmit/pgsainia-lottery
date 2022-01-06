package com.pgsainia.lottery.domain.activity.service.stateflow;

import com.pgsainia.lottery.common.Constants;
import com.pgsainia.lottery.common.Result;
import com.pgsainia.lottery.domain.activity.repository.IActivityRepository;

import javax.annotation.Resource;

/**
 * @author nifujia
 * @description 活动状态抽象类
 * @date 2022/1/6
 */
public abstract class AbstractState {

    @Resource
    protected IActivityRepository activityRepository;

    /**
     * 活动提审
     *
     * @param activityId
     * @param currentStatus
     * @return
     */
    public abstract Result arraignment(Long activityId, Constants.ActivityState currentStatus);

    /**
     * 审核通过
     *
     * @param activityId
     * @param currentStatus
     * @return
     */
    public abstract Result checkPass(Long activityId, Constants.ActivityState currentStatus);

    /**
     * 审核拒绝
     *
     * @param activityId
     * @param currentStatus
     * @return
     */
    public abstract Result checkRefuse(Long activityId, Constants.ActivityState currentStatus);

    /**
     * 撤销审核
     *
     * @param activityId
     * @param currentStatus
     * @return
     */
    public abstract Result checkRevoke(Long activityId, Constants.ActivityState currentStatus);

    /**
     * 活动关闭
     *
     * @param activityId
     * @param currentStatus
     * @return
     */
    public abstract Result close(Long activityId, Constants.ActivityState currentStatus);

    /**
     * 活动开启
     *
     * @param activityId
     * @param currentStatus
     * @return
     */
    public abstract Result open(Long activityId, Constants.ActivityState currentStatus);

    /**
     * 活动执行
     *
     * @param activityId
     * @param currentStatus
     * @return
     */
    public abstract Result doing(Long activityId, Constants.ActivityState currentStatus);

}
