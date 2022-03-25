package javacore.base_practice.time.calendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");

        String time = format.format(Calendar.getInstance().getTime());
        System.out.println("完整的时间和日期： " + time);


        Calendar a = Calendar.getInstance();
        a.set(2017, 7, 25);

        Calendar b = Calendar.getInstance();
        b.set(2017, 8, 25);

        System.out.println("自定义时间：a:" + format2.format(a.getTime()));
        System.out.println("自定义时间：b:" + format2.format(b.getTime()));
        System.out.println("a>b:" + a.compareTo(b));


        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(2015, 11, 9);
        System.out.println("2015-11-09 的毫秒时间是： " + calendar3.getTimeInMillis());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse("20170228"));
//        cal.set(2017,1,28);
        System.out.println("SimpleDateFormat:"+sdf.format(cal.getTime()));

        // 判断date是否是一个月的最后一天，如果是最后一天，则加N个月后还是最后一天。
        if (cal.get(Calendar.DAY_OF_MONTH) == cal.getActualMaximum(Calendar.DAY_OF_MONTH)) {
            System.out.println(sdf.format(cal.getTime()) + "是一个月的最后一天");
        }
        cal.add(Calendar.MONTH, 1);

        System.out.println(sdf.format(cal.getTime()));


        // 比较 compare
        Date day = new Date();
        String DateStr1 = "2011-11-07 15:15:11";
        String DateStr2 = "2011-11-07 15:15:15";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateTime1 = dateFormat.parse(DateStr1);
        Date dateTime2 = dateFormat.parse(DateStr2);
        System.out.println(dateTime1.compareTo(dateTime2));

        // 获取当前发行时间所在年份
        Calendar calendar4 = Calendar.getInstance();
        calendar4.setTimeInMillis(1571932800000L);
        int y = calendar4.get(Calendar.YEAR);
        int m = calendar4.get(Calendar.MONTH);
        int d = calendar4.get(Calendar.DAY_OF_MONTH);
        System.out.println("1571932800000L Millis 表示：" + y + "年"+ m + "月"+ d + "日");

        day.setTime(calendar4.getTimeInMillis());
        System.out.println(dateFormat.format(day));


    }

}