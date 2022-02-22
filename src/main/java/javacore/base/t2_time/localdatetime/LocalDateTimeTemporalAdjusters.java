package javacore.base.t2_time.localdatetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * @Date: 2019-07-24
 * @Version 1.0
 */
public class LocalDateTimeTemporalAdjusters {
    public static void main(String[] args) {

        /**
         * dayOfWeekInMonth	                返回:同一个月中每周的第几天
         * firstDayOfMonth	                返回:当月的第一天
         * firstDayOfNextMonth	            返回:下月的第一天
         * firstDayOfNextYear	            返回:下一年的第一天
         * firstDayOfYear	                返回:本年的第一天
         * firstInMonth	                    返回:同一个月中第一个星期几
         * lastDayOfMonth	                返回:当月的最后一天
         * lastDayOfNextMonth	            返回:下月的最后一天
         * lastDayOfNextYear	            返回:下一年的最后一天
         * lastDayOfYear	                返回:本年的最后一天
         * lastInMonth	                    返回:同一个月中最后一个星期几
         * next / previous	                返回:后一个/前一个给定的星期几
         * nextOrSame / previousOrSame	    返回:后一个/前一个给定的星期几，如果这个值满足条件，直接返回
         */
        LocalDate localDate = LocalDate.now();
        // LocalDate 日期转换操作
        LocalDate localDate1 = localDate.with(TemporalAdjusters.firstDayOfMonth());                 // 本月的第一天
        LocalDate localDate2 = localDate.with(TemporalAdjusters.lastDayOfMonth());                  // 本月的最后一天(无需计算28,30)
        LocalDate localDate3 = localDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));    // 本月的第1个周一

        System.out.println();
        System.out.println("年:" + localDate.getYear() + ",月:" + localDate.getMonth() + ",日:" + localDate.getDayOfMonth());
        System.out.println("本月的第一天: " + localDate1);
        System.out.println("本月的最后一天: " + localDate2);
        System.out.println("本月的第1个周一: " + localDate3);

        // 自定义LocalDate日期操作, 计算下一个工作日{星期1到星期5}
        System.out.println("下一个工作日: " + getNextWorkDay(localDate));
        System.out.println("下一个工作日(lambda表达式): " + getNextWorkDayLambda(localDate));

        System.exit(0);
    }


    /**
     * 自定义LocalDate日期操作
     * 计算下一个工作日{星期1到星期5}
     */
    public static LocalDate getNextWorkDay(LocalDate localDate) {
        return localDate.with(new TemporalAdjuster() {
            @Override
            public Temporal adjustInto(Temporal temporal) {
                DayOfWeek curDay = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));

                // 正常+1天
                int add = 1;
                // 星期五+3天
                if (DayOfWeek.FRIDAY == curDay) {
                    add += 2;
                }
                // 星期六+2天
                if (DayOfWeek.SATURDAY == curDay) {
                    add += 1;
                }
                return temporal.plus(add, ChronoUnit.DAYS);
            }
        });
    }

    /**
     * 自定义LocalDate日期操作
     * 计算下一个工作日{星期1到星期5}lambda表达式
     */
    public static LocalDate getNextWorkDayLambda(LocalDate localDate) {
        return localDate.with(temporal -> {
            DayOfWeek curDay = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
            // 正常+1天
            int add = 1;
            // 星期五+3天
            if (DayOfWeek.FRIDAY == curDay) {
                add += 2;
            }
            // 星期六+2天
            if (DayOfWeek.SATURDAY == curDay) {
                add += 1;
            }
            return temporal.plus(add, ChronoUnit.DAYS);
        });
    }

}
