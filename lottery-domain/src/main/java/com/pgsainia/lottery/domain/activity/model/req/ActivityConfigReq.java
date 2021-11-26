package com.pgsainia.lottery.domain.activity.model.req;

import com.pgsainia.lottery.domain.activity.model.aggregates.ActivityConfigRich;

/**
 * @author nifujia
 * @description 活动配置请求对象
 * @date 2021/11/24
 */
public class ActivityConfigReq {

    /**
     * 活动信息 id
     */
    private Long activityId;
    /**
     * 活动配置信息
     */
    private ActivityConfigRich activityConfigRich;

    public ActivityConfigReq() {
    }

    public ActivityConfigReq(Long activityId, ActivityConfigRich activityConfigRich) {
        this.activityId = activityId;
        this.activityConfigRich = activityConfigRich;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public ActivityConfigRich getActivityConfigRich() {
        return activityConfigRich;
    }

    public void setActivityConfigRich(ActivityConfigRich activityConfigRich) {
        this.activityConfigRich = activityConfigRich;
    }
}
