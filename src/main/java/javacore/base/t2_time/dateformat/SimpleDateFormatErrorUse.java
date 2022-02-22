package javacore.base.t2_time.dateformat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description
 * @date 2020-04-01 11:21
 * @modify
 */
public class SimpleDateFormatErrorUse {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private static final Logger logger = LoggerFactory.getLogger(SimpleDateFormatErrorUse.class);

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            int j = i;
            new Thread(() -> {
                Date date = null;
                String s = "2020-04-" + j;
                try {
                    date = simpleDateFormat.parse(s);
                    logger.info(s + " Time ：" + date.getTime());
                } catch (Exception ex) {
                    logger.error(s + "转换失败;", ex);
                }
            }).start();
        }
    }
}
