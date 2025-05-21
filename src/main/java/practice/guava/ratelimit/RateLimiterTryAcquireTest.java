package practice.guava.ratelimit;

import com.google.common.util.concurrent.RateLimiter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;


@Slf4j
public class RateLimiterTryAcquireTest {

    public static void main(String[] args) {
        // 基于令牌桶算法的限流实现类, 每秒并发数
        RateLimiter rateLimiter = RateLimiter.create(10);
        long s = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            final int ii = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    if (!rateLimiter.tryAcquire(1000, TimeUnit.MILLISECONDS)) {
                        log.info("跳过:{}", ii);
                        return;
                    }
                    long dual = System.currentTimeMillis() - s;
                    log.info("等待时间:" + dual + ",执行方法:" + ii);
                }
            };
            new Thread(runnable).start();
        }
    }
}
