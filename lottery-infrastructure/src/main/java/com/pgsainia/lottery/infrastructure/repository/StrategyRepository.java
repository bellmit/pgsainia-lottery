package com.pgsainia.lottery.infrastructure.repository;

import com.pgsainia.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.pgsainia.lottery.domain.strategy.model.vo.AwardBriefVO;
import com.pgsainia.lottery.domain.strategy.model.vo.StrategyBriefVO;
import com.pgsainia.lottery.domain.strategy.model.vo.StrategyDetailBriefVO;
import com.pgsainia.lottery.domain.strategy.repository.IStrategyRepository;
import com.pgsainia.lottery.infrastructure.dao.IAwardDao;
import com.pgsainia.lottery.infrastructure.dao.IStrategyDao;
import com.pgsainia.lottery.infrastructure.dao.IStrategyDetailDao;
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
 * @date 2021/11/17
 */
@Component
public class StrategyRepository implements IStrategyRepository {

    @Resource
    private IStrategyDao strategyDao;
    @Resource
    private IStrategyDetailDao strategyDetailDao;
    @Resource
    private IAwardDao awardDao;

    @Override
    public StrategyRich queryStrategyRich(Long strategyId) {
        Strategy strategy = strategyDao.queryStrategy(strategyId);
        List<StrategyDetail> strategyDetailList = strategyDetailDao.listStrategyDetail(strategyId);

        StrategyBriefVO strategyBriefVO = new StrategyBriefVO();
        BeanUtils.copyProperties(strategy, strategyBriefVO);

        List<StrategyDetailBriefVO> strategyDetailBriefVOList = new ArrayList<>();
        strategyDetailList.forEach(strategyDetail -> {
            StrategyDetailBriefVO strategyDetailBriefVO = new StrategyDetailBriefVO();
            BeanUtils.copyProperties(strategyDetail, strategyDetailBriefVO);
            strategyDetailBriefVOList.add(strategyDetailBriefVO);
        });
        return new StrategyRich(strategyId, strategyBriefVO, strategyDetailBriefVOList);
    }

    @Override
    public AwardBriefVO queryAwardInfo(String awardId) {
        Award award = awardDao.queryAwardInfo(awardId);
        AwardBriefVO awardBriefVO = new AwardBriefVO();
        awardBriefVO.setAwardId(award.getAwardId());
        awardBriefVO.setAwardName(award.getAwardName());
        awardBriefVO.setAwardType(award.getAwardType());
        awardBriefVO.setAwardContent(award.getAwardContent());
        return awardBriefVO;
    }

    @Override
    public List<String> listNoStockStrategyAwardList(Long strategyId) {
        return strategyDetailDao.listNoStockStrategyAwardList(strategyId);
    }

    @Override
    public boolean deductStock(Long strategyId, String awardId) {
        StrategyDetail strategyDetail = new StrategyDetail();
        strategyDetail.setStrategyId(strategyId);
        strategyDetail.setAwardId(awardId);
        int count = strategyDetailDao.deductStock(strategyDetail);
        return count == 1;
    }
}
