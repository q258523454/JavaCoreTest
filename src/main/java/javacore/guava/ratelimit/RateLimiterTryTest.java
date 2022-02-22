package javacore.guava.ratelimit;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

public class RateLimiterTryTest {

    public static void main(String[] args) {
        // 基于令牌桶算法的限流实现类, 每秒并发数
        RateLimiter rateLimiter = RateLimiter.create(10);
        long s = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            final int ii = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    if (!rateLimiter.tryAcquire(10, TimeUnit.MILLISECONDS)) {
                        return;
                    }
                    long dual = System.currentTimeMillis() - s;
                    System.out.println("等待时间:" + dual + ",执行方法:" + ii);
                }
            };
            new Thread(runnable).start();
        }
    }
}
