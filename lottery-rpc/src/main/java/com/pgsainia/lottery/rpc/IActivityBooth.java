package com.pgsainia.lottery.rpc;

import com.pgsainia.lottery.rpc.req.ActivityReq;
import com.pgsainia.lottery.rpc.res.ActivityRes;

/**
 * @author nifujia
 * @description 活动看板
 * 1、创建活动
 * 2、更新活动
 * 3、查询活动
 * @date 2021/11/15
 */
public interface IActivityBooth {

    /**
     * 查询活动信息
     *
     * @param activityReq
     * @return
     */
    ActivityRes queryActivityById(ActivityReq activityReq);
}
