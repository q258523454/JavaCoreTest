package dateTime;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-08-21
 */

public class GenerateRandomYear {
    public static void main(String[] args) {
        // 创建随机日期
        GregorianCalendar gc = new GregorianCalendar();
        int y = randBetween(2010, 2018);
        gc.set(gc.YEAR, y);
        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyddMM");
        String s = simpleDateFormat.format(new Date(gc.getTimeInMillis()));

        System.out.println(s);

        System.out.println(getRandomYear(2015,2018));
    }

    public static int randBetween(int start, int end) {
//        Min + (int)(Math.random() * ((Max - Min) + 1))
        return start + (int) (Math.random() * ((end - start) + 1));
    }


    public static String getRandomYear(int start, int end) {
        //  Min + (int)(Math.random() * ((Max - Min) + 1))
        int year = start + (int) Math.round(Math.random() * (end - start));
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(gc.YEAR, year);
        int dayOfYear = 1 + (int) Math.round(Math.random() * (gc.getActualMaximum(gc.DAY_OF_YEAR) - 1));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyddMM");
        String sYear = simpleDateFormat.format(new Date(gc.getTimeInMillis()));
        return sYear;
    }
}
