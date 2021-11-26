package com.pgsainia.lottery.infrastructure.dao;

import com.pgsainia.lottery.infrastructure.pojo.Award;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author nifujia
 * @description
 * @date 2021/11/17
 */
@Mapper
public interface IAwardDao {
    /**
     * 根据 awardId 查询奖品信息
     *
     * @param awardId
     * @return
     */
    Award queryAwardInfo(String awardId);

    /**
     * 批量插入奖品信息
     *
     * @param awardList
     */
    void insertBatch(List<Award> awardList);
}
