package com.pgsainia.lottery.domain.activity.service.stateflow.impl;

import com.pgsainia.lottery.common.Constants;
import com.pgsainia.lottery.common.Result;
import com.pgsainia.lottery.domain.activity.service.stateflow.IStateHandler;
import com.pgsainia.lottery.domain.activity.service.stateflow.StateConfig;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author nifujia
 * @description
 * @date 2022/1/6
 */
@Service
public class StateHandler extends StateConfig implements IStateHandler {
    @Override
    public Result arraignment(Long activityId, Constants.ActivityState currentStatus) {
        return stateGroupMap.get(currentStatus).arraignment(activityId, currentStatus);
    }

    @Override
    public Result checkPass(Long activityId, Constants.ActivityState currentStatus) {
        return stateGroupMap.get(currentStatus).checkPass(activityId, currentStatus);
    }

    @Override
    public Result checkRefuse(Long activityId, Constants.ActivityState currentStatus) {
        return stateGroupMap.get(currentStatus).checkRefuse(activityId, currentStatus);
    }

    @Override
    public Result checkRevoke(Long activityId, Constants.ActivityState currentStatus) {
        return stateGroupMap.get(currentStatus).checkRevoke(activityId, currentStatus);
    }

    @Override
    public Result close(Long activityId, Constants.ActivityState currentStatus) {
        return stateGroupMap.get(currentStatus).close(activityId, currentStatus);
    }

    @Override
    public Result open(Long activityId, Constants.ActivityState currentStatus) {
        return stateGroupMap.get(currentStatus).open(activityId, currentStatus);
    }

    @Override
    public Result doing(Long activityId, Constants.ActivityState currentStatus) {
        return stateGroupMap.get(currentStatus).doing(activityId, currentStatus);
    }

}
