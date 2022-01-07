package com.pgsainia.lottery.domain.support.ids;

/**
 * @author nifujia
 * @description 生成 id 接口
 * @date 2022/1/7
 */
public interface IIdGenerator {

    /**
     * ID 生成策略
     * 1、雪花算法，用于生成单号
     * 2、日期算法，用于生成活动编号类，特性是生成数字短，但是指定时间内不能生成太多
     * 3、随机算法，用于生成策略 ID
     *
     * @return
     */
    long nextId();
}
