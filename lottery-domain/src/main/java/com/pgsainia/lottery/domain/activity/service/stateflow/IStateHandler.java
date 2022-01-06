package com.pgsainia.lottery.domain.activity.service.stateflow;

import com.pgsainia.lottery.common.Constants;
import com.pgsainia.lottery.common.Result;

/**
 * @author nifujia
 * @description
 * @date 2022/1/6
 */
public interface IStateHandler {

    /**
     * 提审
     *
     * @param activityId
     * @param currentStatus
     * @return
     */
    Result arraignment(Long activityId, Constants.ActivityState currentStatus);

    /**
     * 审核通过
     *
     * @param activityId
     * @param currentStatus
     * @return
     */
    Result checkPass(Long activityId, Constants.ActivityState currentStatus);

    /**
     * 审核拒绝
     *
     * @param activityId
     * @param currentStatus
     * @return
     */
    Result checkRefuse(Long activityId, Constants.ActivityState currentStatus);

    /**
     * 撤销提审
     *
     * @param activityId
     * @param currentStatus
     * @return
     */
    Result checkRevoke(Long activityId, Constants.ActivityState currentStatus);

    /**
     * 关闭
     *
     * @param activityId
     * @param currentStatus
     * @return
     */
    Result close(Long activityId, Constants.ActivityState currentStatus);

    /**
     * 开启
     *
     * @param activityId
     * @param currentStatus
     * @return
     */
    Result open(Long activityId, Constants.ActivityState currentStatus);

    /**
     * 执行
     *
     * @param activityId
     * @param currentStatus
     * @return
     */
    Result doing(Long activityId, Constants.ActivityState currentStatus);
}
