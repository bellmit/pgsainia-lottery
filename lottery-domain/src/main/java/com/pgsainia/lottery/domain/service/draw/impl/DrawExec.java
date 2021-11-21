package com.pgsainia.lottery.domain.service.draw.impl;

import com.alibaba.fastjson.JSON;
import com.pgsainia.lottery.domain.service.algorithm.IDrawAlgorithm;
import com.pgsainia.lottery.domain.service.draw.AbstractDrawBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nifujia
 * @description
 * @date 2021/11/18
 */
@Service("drawExec")
public class DrawExec extends AbstractDrawBase {

    private final Logger logger = LoggerFactory.getLogger(DrawExec.class);

    @Override
    public List<String> queryExcludeAwardIds(Long strategyId) {
        List<String> noStockStrategyAwardList = strategyRepository.listNoStockStrategyAwardList(strategyId);
        logger.info("执行抽奖策略，strategyId：{}，无奖品排除奖品 id 列表：{}", strategyId, JSON.toJSONString(noStockStrategyAwardList));
        return noStockStrategyAwardList;
    }

    @Override
    public String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<String> excludeAwardIds) {
        // 执行抽奖
        String awardId = drawAlgorithm.randomDraw(strategyId, excludeAwardIds);
        if (awardId == null) {
            return null;
        }

        // 扣减库存（暂时使用数据库行级锁的方式扣减库存，后期优化为分布式扣将库存 desc/incr）
        boolean isSuccess = strategyRepository.deductStock(strategyId, awardId);
        // 返回结果，如果扣减成功，那么返回奖品 id，如果扣减失败，返回 null （在实际的场景中，如果如果中奖奖品库存为空，会有兜底的奖品）
        return isSuccess ? awardId : null;
    }
}
