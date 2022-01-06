package com.pgsainia.lottery.domain.activity.service.stateflow.event;

import com.pgsainia.lottery.common.Constants;
import com.pgsainia.lottery.common.Result;
import com.pgsainia.lottery.domain.activity.service.stateflow.AbstractState;
import org.springframework.stereotype.Component;

/**
 * @author nifujia
 * @description 提审状态
 * @date 2022/1/6
 */
@Component
public class ArraignmentState extends AbstractState {
    @Override
    public Result arraignment(Long activityId, Constants.ActivityState currentStatus) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "待审核状态不可重复提审");
    }

    @Override
    public Result checkPass(Long activityId, Constants.ActivityState currentStatus) {
        boolean success = activityRepository.alterStatus(activityId, currentStatus.getCode(), Constants.ActivityState.PASS.getCode());
        return success ? Result.buildResult(Constants.ResponseCode.SUCCESS, "活动审核通过完成") : Result.buildResult(Constants.ResponseCode.UN_ERROR, "活动变更状态失败");
    }

    @Override
    public Result checkRefuse(Long activityId, Constants.ActivityState currentStatus) {
        boolean success = activityRepository.alterStatus(activityId, currentStatus.getCode(), Constants.ActivityState.REFUSE.getCode());
        return success ? Result.buildResult(Constants.ResponseCode.SUCCESS, "活动审核拒绝完成") : Result.buildResult(Constants.ResponseCode.UN_ERROR, "活动变更状态失败");
    }

    @Override
    public Result checkRevoke(Long activityId, Constants.ActivityState currentStatus) {
        boolean success = activityRepository.alterStatus(activityId, currentStatus.getCode(), Constants.ActivityState.EDIT.getCode());
        return success ? Result.buildResult(Constants.ResponseCode.SUCCESS, "活动撤销到编辑状态成功") : Result.buildResult(Constants.ResponseCode.UN_ERROR, "活动变更状态失败");
    }

    @Override
    public Result close(Long activityId, Constants.ActivityState currentStatus) {
        boolean success = activityRepository.alterStatus(activityId, currentStatus.getCode(), Constants.ActivityState.CLOSE.getCode());
        return success ? Result.buildResult(Constants.ResponseCode.SUCCESS, "活动审核关闭完成") : Result.buildResult(Constants.ResponseCode.UN_ERROR, "活动变更状态失败");
    }

    @Override
    public Result open(Long activityId, Constants.ActivityState currentStatus) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "非关闭状态不可开启");
    }

    @Override
    public Result doing(Long activityId, Constants.ActivityState currentStatus) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "待审核活动不可执行活动中变更");
    }
}
