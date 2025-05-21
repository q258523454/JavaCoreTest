package javacore.base_practice.time.chronounit;

import util.DateUtil;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class ChronoUnitTest {
    public static void main(String[] args) {
        Date date = DateUtil.ymdHmsToDate("2023-03-28 10:21:00");
        LocalDateTime localDateTime = DateUtil.longToLocalDateTime(date.getTime());
        // 计算天数差
        System.out.println(ChronoUnit.DAYS.between(localDateTime, DateUtil.longToLocalDateTime(System.currentTimeMillis())));

        // 当天凌晨
        LocalDateTime curDay = localDateTime.toLocalDate().atStartOfDay();
        LocalDateTime expireDay = DateUtil.longToLocalDateTime(System.currentTimeMillis()).plusDays(1).toLocalDate().atStartOfDay();
        System.out.println(curDay);
        System.out.println(expireDay);
        System.out.println(ChronoUnit.DAYS.between(curDay, expireDay));
        System.out.println(ChronoUnit.DAYS.between(expireDay, curDay));
    }
}
