import util.DateUtil;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExpireUtil {

    private static final DateTimeFormatter yyyyMMddHHmmss = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");


    public static void main(String[] args) {
        // 过期时间2小时=7200000L
        long expires = Instant.now().plusMillis(2 * 60 * 60 * 1000).toEpochMilli();
        // 过期时间24小时=86400000L
        long expirePlus = Instant.now().plusMillis(24 * 60 * 60 * 1000).toEpochMilli();
        long expire = Instant.now().plusMillis(expirePlus).toEpochMilli();
        System.out.println("expire long:" + expire);
        LocalDateTime localDateTime = DateUtil.longToLocalDateTime(expire);
        System.out.println("expire:" + localDateTime.format(yyyyMMddHHmmss));
    }
}
