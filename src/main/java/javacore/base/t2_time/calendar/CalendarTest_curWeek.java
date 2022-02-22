package javacore.base.t2_time.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarTest_curWeek {

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        int currentMonth = calendar.get(Calendar.MONTH);

        System.out.println(currentMonth);

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(dayOfWeek - 1);

        Calendar start = Calendar.getInstance();
        start.add(Calendar.DAY_OF_MONTH, 1);

        Calendar end = Calendar.getInstance();
        end.add(Calendar.DAY_OF_MONTH, 3);

        SimpleDateFormat format3 = new SimpleDateFormat("yyyy-MM-dd");
        String time = format3.format(start.getTime());
        System.out.println("日期1： " + time);
        String time2 = format3.format(end.getTime());
        System.out.println("日期2： " + time2);

        // 计算两个Calendar之差(天数)
        long diff = (end.getTimeInMillis() - start.getTimeInMillis()) / (24 * 60 * 60 * 1000);
        System.out.println("相差天数:" + diff);
    }

}