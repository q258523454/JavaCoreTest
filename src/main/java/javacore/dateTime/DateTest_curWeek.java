package javacore.dateTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class  DateTest_curWeek{

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        int currentMonth = calendar.get(Calendar.MONTH);

        System.out.println(currentMonth);

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(dayOfWeek-1);

        Calendar start = Calendar.getInstance();
        start.add(Calendar.DAY_OF_MONTH, Calendar.MONDAY - dayOfWeek);

        Calendar end = Calendar.getInstance();
        end.add(Calendar.DAY_OF_MONTH, Calendar.SUNDAY - dayOfWeek + 7);

        SimpleDateFormat format3 = new SimpleDateFormat("yyyy-MM-dd");
        String time = format3.format(start.getTime());
        System.out.println("完整的日期： " + time);
        String time2 = format3.format(end.getTime());
        System.out.println("完整的日期： " + time2);

        // 计算两个Calendar之差(天数)
        long diff = (end.getTimeInMillis() - start.getTimeInMillis()) / (24 * 60 * 60 * 1000);
        System.out.println(diff);


        String assetTypesChinese = "租赁租金";
        assetTypesChinese = ("租赁资产".equals(assetTypesChinese) ? "金融租赁" : ("租赁租金".equals(assetTypesChinese) ? "融资租赁" : assetTypesChinese));
        System.out.println(assetTypesChinese);

    }

}