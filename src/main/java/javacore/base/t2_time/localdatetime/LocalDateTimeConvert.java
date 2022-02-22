package javacore.base.t2_time.localdatetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;

/**
 * @Date: 2019-07-26
 * @Version 1.0
 */
public class LocalDateTimeConvert {
    public static void main(String[] args) throws ParseException {

        // ------------------------ long(Date,Calendar) 转 LocalDateTime -----------------------------------
        // long(Date) 转 LocalDateTime
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date myDate = simpleDateFormat.parse("2019-08-16");
        long mills = myDate.getTime();
        LocalDateTime localDateTime1 = Instant.ofEpochMilli(mills).atZone(ZoneId.systemDefault()).toLocalDateTime();

        // long(calendar) 转 LocalDateTime
        Calendar calendar = Calendar.getInstance();
        mills = calendar.getTimeInMillis();
        ZonedDateTime zonedDateTim = Instant.ofEpochMilli(mills).atZone(ZoneId.systemDefault());
        LocalDateTime localDateTim = zonedDateTim.toLocalDateTime();

        // LocalDateTime 转 long (Millis)
        // LocalDateTime --> 时区zonedDateTime --> Instant
        ZonedDateTime zonedDateTime = localDateTime1.atZone(ZoneId.systemDefault());
        System.out.println(zonedDateTime.toInstant().toEpochMilli());


        // LocalDateTime 转 LocalDate 和 LocalTime
        LocalDate localDate = localDateTime1.toLocalDate();
        LocalTime localTime = localDateTime1.toLocalTime();

        // LocalDate 和 LocalTime 合并转成 LocalDateTime
        LocalDateTime combime = LocalDateTime.of(localDate, localTime);
        System.out.println("当前 date: " + localDate);
        System.out.println("当前 time: " + localTime);
        System.out.println("当前 localDateTime: " + combime);


    }
}
