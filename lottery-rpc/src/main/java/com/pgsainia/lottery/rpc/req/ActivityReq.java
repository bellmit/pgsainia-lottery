package com.pgsainia.lottery.rpc.req;

import java.io.Serializable;

/**
 * @author nifujia
 * @description
 * @date 2021/11/15
 */
public class ActivityReq implements Serializable {
    /**
     * 活动 id
     */
    private Long activityId;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }
}
