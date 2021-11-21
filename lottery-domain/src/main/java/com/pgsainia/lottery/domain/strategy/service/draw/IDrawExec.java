package com.pgsainia.lottery.domain.strategy.service.draw;

import com.pgsainia.lottery.domain.strategy.model.req.DrawReq;
import com.pgsainia.lottery.domain.strategy.model.res.DrawResult;

/**
 * @author nifujia
 * @description
 * @date 2021/11/18
 */
public interface IDrawExec {

    /**
     * 抽奖
     *
     * @param drawReq
     * @return
     */
    DrawResult doDrawExec(DrawReq drawReq);

}
