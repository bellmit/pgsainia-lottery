package com.pgsainia.lottery.interfaces;

import com.pgsainia.lottery.common.Result;
import com.pgsainia.lottery.infrastructure.dao.IActivityDao;
import com.pgsainia.lottery.infrastructure.pojo.Activity;
import com.pgsainia.lottery.rpc.IActivityBooth;
import com.pgsainia.lottery.rpc.dto.ActivityDto;
import com.pgsainia.lottery.rpc.req.ActivityReq;
import com.pgsainia.lottery.rpc.res.ActivityRes;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * @author nifujia
 * @description
 * @date 2021/11/16
 */
@Service
public class ActivityBooth implements IActivityBooth {
    @Resource
    private IActivityDao activityDao;

    @Override
    public ActivityRes queryActivityById(ActivityReq activityReq) {
        Activity activity = activityDao.queryActivityById(activityReq.getActivityId());
        ActivityDto activityDto = new ActivityDto();
        activityDto.setActivityId(activity.getActivityId());
        activityDto.setActivityName(activity.getActivityName());
        activityDto.setActivityDesc(activity.getActivityDesc());
        activityDto.setBeginDateTime(activity.getBeginDateTime());
        activityDto.setEndDateTime(activity.getEndDateTime());
        activityDto.setState(activity.getState());
        activityDto.setStockCount(activity.getStockCount());
        activityDto.setTakeCount(activity.getTakeCount());

        return new ActivityRes(Result.buildSuccess(), activityDto);
    }
}
