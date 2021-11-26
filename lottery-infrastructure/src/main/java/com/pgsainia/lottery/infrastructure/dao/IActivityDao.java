package com.pgsainia.lottery.infrastructure.dao;

import com.pgsainia.lottery.domain.activity.model.vo.AlterStateVO;
import com.pgsainia.lottery.infrastructure.pojo.Activity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author nifujia
 * @description
 * @date 2021/11/15
 */
@Mapper
public interface IActivityDao {

    /**
     * 插入活动数据
     *
     * @param activity
     */
    void insert(Activity activity);

    /**
     * 根据活动 id 查询活动信息
     *
     * @param activityId
     * @return
     */
    Activity queryActivityById(Long activityId);

    /**
     * 变更活动状态
     * @param alterState
     * @return
     */
    int alterState(AlterStateVO alterState);
}
