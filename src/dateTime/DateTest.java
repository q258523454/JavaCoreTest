package dateTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

    public static void main(String[] args) throws ParseException {



        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        SimpleDateFormat format11=new SimpleDateFormat("yyyyMMdd");
        String time = format.format(Calendar.getInstance().getTime());
        System.out.println("完整的时间和日期： " + time);
        String time11 = format11.format(Calendar.getInstance().getTime());
        String timeStr = time11;
        System.out.println("完整的时间和日期： " + timeStr);

        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        String time2 = format2.format(Calendar.getInstance().getTime());
        System.out.println("完整的日期： " + time2);

        SimpleDateFormat format3 = new SimpleDateFormat("HH-mm-ss-SSS");
        String time3 = format3.format(Calendar.getInstance().getTime());
        System.out.println("完整的时间： " + time3);

        Calendar a=Calendar.getInstance();
        a.set(2017,7,25);

        Calendar b=Calendar.getInstance();
        b.set(2017,8,25);

        System.out.println("自定义时间："+format2.format(a.getTime()));

        System.out.println(a.compareTo(b));


        Calendar calendar1 = Calendar.getInstance();
        String time4 = format2.format(calendar1.getTime());
        System.out.println("完整的日期： " + time4);

        Calendar calendar2 = Calendar.getInstance();
        System.out.println("今天日期的毫秒时间： "+ calendar2.getTimeInMillis());
        calendar2.setTimeInMillis(calendar2.getTimeInMillis());


        String time5 = format2.format(calendar2.getTime());
        System.out.println("完整的日期： " + time5);

        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(2015,11,9);
        System.out.println("2015-11-09 的毫秒时间是： "+ calendar3.getTimeInMillis());


        // 获取当前发行时间所在年份
        Calendar calendar4 = Calendar.getInstance();
        calendar4.setTimeInMillis(1450886400000L);
        int year = calendar4.get(Calendar.YEAR);
        System.out.println("1450886400000L Millis 表示："+year+"  年");




        /* test 2 */
        System.out.println("\ntest2:");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse("20170228"));
//        cal.set(2017,1,28);
        System.out.println(sdf.format(cal.getTime()));

        // 判断date是否是一个月的最后一天，如果是最后一天，则加N个月后还是最后一天。
        Boolean isLastDay=false;
        if(cal.get(Calendar.DAY_OF_MONTH)== cal.getActualMaximum(Calendar.DAY_OF_MONTH)){
            System.out.println("yes");
            isLastDay=true;
        }
        cal.add(Calendar.MONTH,1);

        // date要不是一个月的最后一天呢？加上N个月之后怎么计算？如果是1.30号+1个月，难道是2.30? 但是2月只有28
        if(isLastDay){
            System.out.println("yes");
            cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        }

        System.out.println(sdf.format(cal.getTime()));


        Date day=new Date();
        String DateStr1 = "2011-11-07 15:16:11";
        String DateStr2 = "2011-11-07 15:15:15";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateTime1 = dateFormat.parse(DateStr1);
        Date dateTime2 = dateFormat.parse(DateStr2);
        int i = dateTime2.compareTo(dateTime2);
        System.out.println(i == 0);

    }

}