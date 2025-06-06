package util;

import java.sql.Timestamp;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SystemClockUtil {
    /**
     * 时钟更新间隔，单位毫秒
     */
    private final long period;
    /**
     * 现在时刻的毫秒数
     */
    private volatile long now;

    /**
     * 构造
     *
     * @param period 时钟更新间隔，单位毫秒
     */
    public SystemClockUtil(long period) {
        this.period = period;
        this.now = System.currentTimeMillis();
        scheduleClockUpdating();
    }

    /**
     * 开启计时器线程
     */
    private void scheduleClockUpdating() {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor(runnable -> {
            Thread thread = new Thread(runnable, "System Clock");
            thread.setDaemon(true);
            return thread;
        });
        scheduler.scheduleAtFixedRate(() -> now = System.currentTimeMillis(), period, period, TimeUnit.MILLISECONDS);
    }

    /**
     * @return 当前时间毫秒数
     */
    private long currentTimeMillis() {
        return now;
    }

    //------------------------------------------------------------------------ static

    /**
     * 单例
     *
     * @author Looly
     */
    private static class InstanceHolder {
        public static final SystemClockUtil INSTANCE = new SystemClockUtil(1);
    }

    /**
     * @return 当前时间
     */
    public static long now() {
        return SystemClockUtil.InstanceHolder.INSTANCE.currentTimeMillis();
    }

    /**
     * @return 当前时间字符串表现形式
     */
    public static String nowDate() {
        return new Timestamp(SystemClockUtil.InstanceHolder.INSTANCE.currentTimeMillis()).toString();
    }
}
