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
public class OpenState extends AbstractState {
    @Override
    public Result arraignment(Long activityId, Constants.ActivityState currentStatus) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "活动开启不可提审");
    }

    @Override
    public Result checkPass(Long activityId, Constants.ActivityState currentStatus) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "活动开启不可审核通过");
    }

    @Override
    public Result checkRefuse(Long activityId, Constants.ActivityState currentStatus) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "活动开启不可审核拒绝");
    }

    @Override
    public Result checkRevoke(Long activityId, Constants.ActivityState currentStatus) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "活动开启不可撤销审核");
    }

    @Override
    public Result close(Long activityId, Constants.ActivityState currentStatus) {
        boolean success = activityRepository.alterStatus(activityId, currentStatus.getCode(), Constants.ActivityState.CLOSE.getCode());
        return success ? Result.buildResult(Constants.ResponseCode.SUCCESS, "活动关闭完成") : Result.buildResult(Constants.ResponseCode.UN_ERROR, "活动状态变更失败");
    }

    @Override
    public Result open(Long activityId, Constants.ActivityState currentStatus) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "活动开启不可重复开启");
    }

    @Override
    public Result doing(Long activityId, Constants.ActivityState currentStatus) {
        boolean success = activityRepository.alterStatus(activityId, currentStatus.getCode(), Constants.ActivityState.DOING.getCode());
        return success ? Result.buildResult(Constants.ResponseCode.SUCCESS, "活动变更为进行中成功") : Result.buildResult(Constants.ResponseCode.UN_ERROR, "活动状态变更失败");
    }

}
