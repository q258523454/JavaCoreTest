package javacore.base.t2_time.localdatetime;

import java.text.ParseException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * @Date: 2019-07-24
 * @Version 1.0
 */
public class LocalDateTimeBase {
    public static void main(String[] args) throws ParseException {
        /**
         * JDK 1.8 时间新特性: 解决java.util.Date线程不安全
         * LocalDate: 仅表示日期         对应mysql中的date
         * LocalTime: 仅表示时间         对应mysql中的time
         * LocalDateTime: 日期和时间     对应mysql中的timestamp
         */
        LocalDate localDate = LocalDate.now();  // System.out.println:2020-03-23
        LocalTime localTime = LocalTime.now();  // System.out.println:09:38:47.594
        LocalDateTime localDateTime = LocalDateTime.now();  // System.out.println:2020-03-23T09:38:47.594

        // -------------------------------- LocalDate BEGIN --------------------------------

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = LocalDate.now(ZoneId.of("Asia/Shanghai"));
        LocalDate localDate3 = LocalDate.of(2019, 8, 8);
        LocalDate localDate4 = LocalDate.parse("2019-08-08");       // 默认ISO标准: yyyy-MM-dd

        // LocalDate 日期转换操作
        LocalDate localDate5 = localDate.with(TemporalAdjusters.firstDayOfMonth());        // 本月的第一天
        LocalDate localDate6 = localDate.withDayOfMonth(2);                                // 本月的第二天
        LocalDate localDate7 = localDate.with(TemporalAdjusters.lastDayOfMonth());         // 本月的最后一天(无需计算28,30)
        LocalDate localDate8 = localDate.plusDays(1);                                      // 当天+1, plusYears, minusMonths, etc..
        LocalDate localDate9 = localDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));   // 本月的第1个周一
        int dayOfWeek = localDate.getDayOfWeek().getValue();                               // 本周的第几天
        int length = localDate.lengthOfMonth();                                            // 月份的天数
        boolean leapYear = localDate.isLeapYear();                                         // 是否为闰年：false


        Period.between(localDate1, localDate2);

        System.out.println();
        System.out.println("年:" + localDate.getYear() + ",月:" + localDate.getMonth() + ",日:" + localDate.getDayOfMonth());
        System.out.println("LocalDate.now(): " + localDate1);
        System.out.println("LocalDate.now(ZoneId.of('Asia/Shanghai')): " + localDate2);
        System.out.println("LocalDate.of(2019, 8, 8): " + localDate3);
        System.out.println("LocalDate.parse('2019-08-08'): " + localDate4);
        System.out.println("ofPattern('yyyy/MM/dd'): " + localDate3.format(dateTimeFormatter));
        System.out.println("本月的第一天: " + localDate5);
        System.out.println("本月的第二天: " + localDate6);
        System.out.println("本月的最后一天: " + localDate7);
        System.out.println("当天+1: " + localDate8);
        System.out.println("本月的第1个周一: " + localDate9);
        System.out.println("本周的第几天: " + dayOfWeek);
        System.out.println("月份的天数: " + length);
        System.out.println("是否为闰年: " + leapYear);

        // -------------------------------- LocalDate END --------------------------------


        // -------------------------------- localTime BEGIN --------------------------------

        LocalTime localTime1 = LocalTime.now();                     // 默认ISO标准: HH:mm:ss:SSS
        LocalTime localTime2 = LocalTime.now().withNano(0);         // 去毫秒
        LocalTime localTime3 = LocalTime.of(12, 00, 00);
        LocalTime localTime4 = LocalTime.parse("12:00:00");         // 默认ISO标准: HH:mm:ss

        System.out.println();
        System.out.println("时: " + localTime.getHour() + ",分: " + localTime.getMinute() + ",秒: " + localTime.getSecond());
        System.out.println("LocalTime.now(): " + localTime1);
        System.out.println("LocalTime.now().withNano(0): " + localTime2); // 去毫秒
        System.out.println("LocalTime.of(12, 00, 00): " + localTime3);
        System.out.println("LocalTime.parse('12:00:00'): " + localTime4);

        // -------------------------------- localTime BEGIN --------------------------------

        // -------------------------------- LocalDateTime BEGIN --------------------------------

        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 1, 1, 19, 30, 0);
        LocalDate date = localDateTime1.toLocalDate();
        LocalTime time = localDateTime1.toLocalTime();
        LocalDateTime combime = LocalDateTime.of(date, time);

        System.out.println("当前 date: " + date);
        System.out.println("当前 time: " + time);
        System.out.println("当前 localDateTime: " + combime);
        // -------------------------------- LocalDateTime BEGIN --------------------------------

    }
}
