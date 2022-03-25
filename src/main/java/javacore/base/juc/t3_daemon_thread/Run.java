package javacore.base.juc.t3_daemon_thread;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Run {

    public static void main(String[] args) throws InterruptedException {

        DamonThreadTask runnable = new DamonThreadTask("zhang");
        runnable.start();
        runnable.start();

        Thread thread = new Thread(runnable);
        thread.start();
        runnable.setRunStatus(false);

        Thread.sleep(400);

        runnable.setRunStatus(false);

        while (!runnable.getExecutor().isTerminated()) {
            // 等待所有线程执行完成
        }
        log.info(" Threads Have Finished");

    }
}
