package com.pgsainia.lottery.infrastructure.repository;

import com.pgsainia.lottery.domain.activity.model.vo.ActivityVO;
import com.pgsainia.lottery.domain.activity.model.vo.AwardVO;
import com.pgsainia.lottery.domain.activity.model.vo.StrategyDetailVO;
import com.pgsainia.lottery.domain.activity.model.vo.StrategyVO;
import com.pgsainia.lottery.domain.activity.repository.IActivityRepository;
import com.pgsainia.lottery.infrastructure.dao.IActivityDao;
import com.pgsainia.lottery.infrastructure.dao.IAwardDao;
import com.pgsainia.lottery.infrastructure.pojo.Activity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
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

    @Override
    public void addActivity(ActivityVO activity) {
        Activity request = new Activity();
        BeanUtils.copyProperties(activity, request);
        activityDao.insert(request);
    }

    @Override
    public void addStrategy(StrategyVO strategy) {

    }

    @Override
    public void addStrategyDetailList(List<StrategyDetailVO> strategyDetailList) {

    }

    @Override
    public void addAward(List<AwardVO> awardList) {

    }
}
