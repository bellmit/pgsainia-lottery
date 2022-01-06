package com.pgsainia.lottery.domain.activity.service.stateflow.event;

import com.pgsainia.lottery.common.Constants;
import com.pgsainia.lottery.common.Result;
import com.pgsainia.lottery.domain.activity.service.stateflow.AbstractState;
import org.springframework.stereotype.Component;

/**
 * @author nifujia
 * @description
 * @date 2022/1/6
 */
@Component
public class PassState extends AbstractState {
    @Override
    public Result arraignment(Long activityId, Constants.ActivityState currentStatus) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "已审核状态不可重复提审");
    }

    @Override
    public Result checkPass(Long activityId, Constants.ActivityState currentStatus) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "已审核状态不可重复审核通过");
    }

    @Override
    public Result checkRefuse(Long activityId, Constants.ActivityState currentStatus) {
        boolean success = activityRepository.alterStatus(activityId, currentStatus.getCode(), Constants.ActivityState.REFUSE.getCode());
        return success ? Result.buildResult(Constants.ResponseCode.SUCCESS, "活动审核拒绝完成") : Result.buildResult(Constants.ResponseCode.UN_ERROR, "活动状态变更失败");
    }

    @Override
    public Result checkRevoke(Long activityId, Constants.ActivityState currentStatus) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "已审核状态不可撤销（可先拒绝审核）");
    }

    @Override
    public Result close(Long activityId, Constants.ActivityState currentStatus) {
        boolean success = activityRepository.alterStatus(activityId, currentStatus.getCode(), Constants.ActivityState.CLOSE.getCode());
        return success ? Result.buildResult(Constants.ResponseCode.SUCCESS, "活动关闭完成") : Result.buildResult(Constants.ResponseCode.UN_ERROR, "活动状态变更失败");
    }

    @Override
    public Result open(Long activityId, Constants.ActivityState currentStatus) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "非关闭状态不可开启");
    }

    @Override
    public Result doing(Long activityId, Constants.ActivityState currentStatus) {
        boolean success = activityRepository.alterStatus(activityId, currentStatus.getCode(), Constants.ActivityState.DOING.getCode());
        return success ? Result.buildResult(Constants.ResponseCode.SUCCESS, "活动变更为进行中完成") : Result.buildResult(Constants.ResponseCode.UN_ERROR, "活动状态变更失败");
    }

}
