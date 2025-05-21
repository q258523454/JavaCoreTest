package javacore.base.juc.t3_daemon_thread;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Run {

    public static void main(String[] args) throws InterruptedException {

        /**
         * 这里的写法禁止使用 Thread.start() ,因为它调用的 Runnable.run()
         */
        DamonThreadTask damonRunnable = new DamonThreadTask("zhang");
        // log.info("开启一个匿名后台任务");
        damonRunnable.start();
        // log.info("同一个匿名后台任务,不会重新执行");
        damonRunnable.start();

        // 2秒后, 关闭后台线程
        Thread.sleep(2000);
        damonRunnable.setRunStatus(false);

        while (!damonRunnable.getExecutor().isTerminated()) {
            // 等待所有线程执行完成
        }
        log.info("damon task stoped");
    }
}
