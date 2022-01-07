package com.pgsainia.lottery.domain.support.ids.policy;

import com.pgsainia.lottery.domain.support.ids.IIdGenerator;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

/**
 * @author nifujia
 * @description 随机生成 id
 * @date 2022/1/7
 */
@Component
public class RandomNumeric implements IIdGenerator {
    @Override
    public long nextId() {
        String randomNumeric = RandomStringUtils.randomNumeric(11);
        return Long.parseLong(randomNumeric);
    }
}
