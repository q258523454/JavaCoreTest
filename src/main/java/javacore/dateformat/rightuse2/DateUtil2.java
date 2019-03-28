package javacore.dateformat.rightuse2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-22
 */
public class DateUtil2 {
    private static final ThreadLocal<SimpleDateFormat> sdf = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };


    public static String formatFromDate(Date date) throws ParseException {
        return sdf.get().format(date);
    }

    public static Date parseToDate(String strDate) throws ParseException {
        return sdf.get().parse(strDate);
    }
}
