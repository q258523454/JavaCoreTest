package practice.guava.ratelimit;


import com.google.common.util.concurrent.RateLimiter;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class RateLimiterWarmupPeriodTest {

    @SneakyThrows
    public static void main(String[] args) {

        /**
         * @param permitsPerSecond 期望每秒并发数
         * @param warmupPeriod "热身"时间
         *                     1.预热时间内 RateLimiter 每秒分配的许可数会平稳地增长直到预热期结束时达到其最大速率
         *                     2.warmupPeriod 时间内闲置不用, 它将会逐步地返回冷却状态。超过时间, 再次启动则会像它第一次被创建般经历同样的预热期
         *                     3.一般应用于需要预热的API调用
         *
         * @param unit warmupPeriod 的单位
         */
        RateLimiter limiter = RateLimiter.create(10, 3000, TimeUnit.MILLISECONDS);
        extracted(limiter);
        extracted(limiter);
        System.out.println("------------------------------");
        RateLimiter limiter2 = RateLimiter.create(5, 400, TimeUnit.MILLISECONDS);
        extracted(limiter2);
        extracted(limiter2);
    }

    /**
     * 打印 RateLimiter
     */
    @SneakyThrows
    private static void extracted(RateLimiter limiter) {
        Thread.sleep(500L);
        for (int i = 0; i < 10; i++) {
            System.out.println(limiter.acquire());
        }
    }
}
