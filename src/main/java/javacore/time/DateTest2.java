package javacore.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTest2 {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        String time = simpleDateFormat.format(calendar.getTime());
        System.out.println("完整的日期： " + time);

        calendar.add(Calendar.MONTH,1);
        time = simpleDateFormat.format(calendar.getTime());
        System.out.println("完整的日期： " + time);

        int m=11;
        calendar.set(2014,m,1);
        time = simpleDateFormat.format(calendar.getTime());
        System.out.println("完整的日期： " + time);
        calendar.set(2014, m, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));  // 注意日期为当月的最后一天
        time = simpleDateFormat.format(calendar.getTime());
        System.out.println("完整的日期： " + time);


        calendar.set(2014, m,1);  // 注意日期为当月的最后一天
        System.out.println(calendar.getTimeInMillis());
        time = simpleDateFormat.format(calendar.getTime());
        calendar.add(Calendar.MONTH,1);
        System.out.println(calendar.getTimeInMillis());


        calendar.set(2014, m,1);  // 注意日期为当月的最后一天
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        System.out.println(calendar.getTimeInMillis());
        calendar.add(Calendar.MONTH,1);
        System.out.println(calendar.getTimeInMillis());
        System.out.println(calendar.get(Calendar.MONTH));


    }

}