package javacore.base.t2_time.localdatetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Description
 * @date 2020-04-07 19:38
 * @modify
 */
public class LocalDateTimeBetween {


    public static void main(String[] args) {

        final DateTimeFormatter ymd = DateTimeFormatter.ofPattern("yyyyMMdd");
        final DateTimeFormatter ymdHms = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        final DateTimeFormatter ymdHmsSSS = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");


        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 1, 4, 0, 0, 0);
        LocalDateTime localDateTime2 = LocalDateTime.of(2019, 1, 4, 0, 0, 0);
        Duration duration = Duration.between(localDateTime1, localDateTime2);
        System.out.println(duration.toDays());


        // -------------------------------------- between to days ----------------------------------
        LocalDate localDate1 = LocalDate.parse("20100303", ymd);
        LocalDate localDate2 = LocalDate.parse("20100203", ymd);
        Duration between = Duration.between(localDate1.atStartOfDay(), localDate2.atStartOfDay());
        System.out.println(between.toDays());

        // --------------------------------------parse & format ----------------------------------
        LocalDateTime p2 = LocalDateTime.parse("20100101162211", ymdHms);
        System.out.println(p2);
        System.out.println(p2.format(ymdHmsSSS));

    }
}
