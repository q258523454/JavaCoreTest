package javacore.dateformat.rightuse1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-22
 */
public class DateUtil {
    private static volatile SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String formatFromDate(Date date) throws ParseException {
        //方式一:让内存不共享，到用的时候再创建私有对象,使用时注释掉全局变量sdf
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //return sdf.format(date);
        //方式二:加锁,使用时打开全局变量sdf的注释
        synchronized (sdf) {
            return sdf.format(date);
        }
    }

    public static Date parseToDate(String strDate) throws ParseException {
        //方式一:使用时注释掉全局变量sdf
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //return sdf.parse(strDate);
        //方式二:加锁,使用时打开全局变量sdf的注释
        synchronized (sdf) {
            return sdf.parse(strDate);
        }
    }
}
