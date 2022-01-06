package com.pgsainia.lottery.infrastructure.repository;

import com.pgsainia.lottery.domain.activity.model.vo.*;
import com.pgsainia.lottery.domain.activity.repository.IActivityRepository;
import com.pgsainia.lottery.infrastructure.dao.IActivityDao;
import com.pgsainia.lottery.infrastructure.dao.IAwardDao;
import com.pgsainia.lottery.infrastructure.dao.IStrategyDao;
import com.pgsainia.lottery.infrastructure.dao.IStrategyDetailDao;
import com.pgsainia.lottery.infrastructure.pojo.Activity;
import com.pgsainia.lottery.infrastructure.pojo.Award;
import com.pgsainia.lottery.infrastructure.pojo.Strategy;
import com.pgsainia.lottery.infrastructure.pojo.StrategyDetail;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nifujia
 * @description
 * @date 2021/11/24
 */
@Component
public class ActivityRepository implements IActivityRepository {

    @Resource
    private IActivityDao activityDao;
    @Resource
    private IAwardDao awardDao;
    @Resource
    private IStrategyDao strategyDao;
    @Resource
    private IStrategyDetailDao strategyDetailDao;

    @Override
    public void addActivity(ActivityVO activity) {
        Activity request = new Activity();
        BeanUtils.copyProperties(activity, request);
        activityDao.insert(request);
    }

    @Override
    public void addStrategy(StrategyVO strategy) {
        Strategy request = new Strategy();
        BeanUtils.copyProperties(strategy, request);
        strategyDao.insert(request);
    }

    @Override
    public void addStrategyDetailList(List<StrategyDetailVO> strategyDetailList) {
        List<StrategyDetail> list = new ArrayList<>();
        strategyDetailList.forEach(item -> {
            StrategyDetail strategyDetail = new StrategyDetail();
            BeanUtils.copyProperties(item, strategyDetail);
            list.add(strategyDetail);
        });

        strategyDetailDao.insertList(list);
    }

    @Override
    public void addAward(List<AwardVO> awardList) {
        List<Award> list = new ArrayList<>();
        awardList.forEach(item -> {
            Award award = new Award();
            BeanUtils.copyProperties(item, award);
            list.add(award);
        });

        awardDao.insertBatch(list);
    }

    @Override
    public boolean alterStatus(Long activityId, Integer beforeStatus, Integer afterStatus) {
        AlterStateVO alterStateVO = new AlterStateVO(activityId, beforeStatus, afterStatus);
        int count = activityDao.alterState(alterStateVO);
        return count == 1;
    }
}
