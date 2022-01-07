package com.pgsainia.lottery.domain.support.ids;

import com.pgsainia.lottery.common.Constants;
import com.pgsainia.lottery.domain.support.ids.policy.RandomNumeric;
import com.pgsainia.lottery.domain.support.ids.policy.ShortCode;
import com.pgsainia.lottery.domain.support.ids.policy.SnowFlake;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nifujia
 * @description Id 策略模式上下文配置（在正式的完整的系统架构中，Id 的生成会有单独的服务生成，其他服务调用 ID 服务生成接口即可）
 * @date 2022/1/7
 */
@Configuration
public class IdContext {

    /**
     * 创建 id 生成策略对象
     *
     * @param snowFlake     雪花算法，大量，长码
     * @param shortCode     日期算法，少量，短码，全局唯一性需要自己保证
     * @param randomNumeric 随机算法，大量，短码，全局唯一性需要自己保证
     * @return
     */
    @Bean
    public Map<Constants.Ids, IIdGenerator> idGenerator(SnowFlake snowFlake, ShortCode shortCode, RandomNumeric randomNumeric) {
        Map<Constants.Ids, IIdGenerator> iIdGeneratorMap = new HashMap<>(4);
        iIdGeneratorMap.put(Constants.Ids.SnowFlake, snowFlake);
        iIdGeneratorMap.put(Constants.Ids.ShortCode, shortCode);
        iIdGeneratorMap.put(Constants.Ids.RandomNumeric, randomNumeric);
        return iIdGeneratorMap;
    }

}
