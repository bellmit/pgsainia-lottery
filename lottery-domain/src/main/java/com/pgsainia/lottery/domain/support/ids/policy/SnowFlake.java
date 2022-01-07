package com.pgsainia.lottery.domain.support.ids.policy;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import com.pgsainia.lottery.domain.support.ids.IIdGenerator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author nifujia
 * @description hutool 包底下的雪花算法，15位雪花算法推荐：
 * https://github.com/yitter/idgenerator/blob/master/Java/source/src/main/java/com/github/yitter/core/SnowWorkerM1.java
 * @date 2022/1/7
 */
@Component
public class SnowFlake implements IIdGenerator {

    private Snowflake snowflake;

    @PostConstruct
    public void init() {
        // 0 ~ 31 位，可以采用配置的方式
        long workerId;
        try {
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        } catch (Exception e) {
            workerId = NetUtil.getLocalhostStr().hashCode();
        }
        workerId = workerId >> 16 & 31;

        long datacenterId = 1L;
        snowflake = IdUtil.createSnowflake(workerId, datacenterId);
    }

    @Override
    public long nextId() {
        return snowflake.nextId();
    }
}
