package com.pgsainia.lottery.domain.support.ids.policy;

import com.pgsainia.lottery.domain.support.ids.IIdGenerator;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Random;

/**
 * @author nifujia
 * @description
 * @date 2022/1/7
 */
@Component
public class ShortCode implements IIdGenerator {
    @Override
    public long nextId() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        // 打乱排序：2020 年准 + 小时 + 周期 + 日 + 三位随机数   210026541
        StringBuilder sb = new StringBuilder();
        sb.append(year - 2020);
        sb.append(hour);
        sb.append(String.format("%02d", week));
        sb.append(day);
        sb.append(String.format("%03d", new Random().nextInt(1000)));

        return Long.parseLong(sb.toString());
    }
}
