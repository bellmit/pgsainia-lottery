package com.pgsainia.lottery.domain.activity.service.deploy;

import com.pgsainia.lottery.domain.activity.model.req.ActivityConfigReq;

/**
 * @author nifujia
 * @description
 * @date 2022/1/6
 */
public interface IActivityDeploy {

    /**
     * 创建活动信息
     *
     * @param activityConfigReq
     */
    void createActivity(ActivityConfigReq activityConfigReq);

    /**
     * 修改活动信息
     *
     * @param activityConfigReq
     */
    void updateActivity(ActivityConfigReq activityConfigReq);
}
