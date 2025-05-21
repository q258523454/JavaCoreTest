package practice.guava.ratelimit;


import com.google.common.util.concurrent.RateLimiter;

public class RateLimiterAcquireTest {

    public static void main(String[] args) {
        // 基于令牌桶算法的限流实现类, 每秒并发数
        RateLimiter rateLimiter = RateLimiter.create(2);
        for (int i = 0; i < 20; i++) {
            // rateLimiter.tryAcquire
            double acquire = rateLimiter.acquire();
            final int ii = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("等待时间:" + acquire + ",执行方法:" + ii);
                }
            };
            new Thread(runnable).start();
        }
    }
}
