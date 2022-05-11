package javacore.base.juc.t3_multi_thread.t5_futuretask.t3_executorservice_submit_nonblock;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class MyRunnable implements Runnable {
    private String command;

    private long timeout;

    @Override
    public void run() {
        try {
            log.info("嵌套子线程: " + Thread.currentThread().getName() + " Start. Command = " + command + ",timeout is :" + timeout);
            // 假设有10个任务， 每个任务执行的时间
            long t = timeout / 10;
            if (!Thread.currentThread().isInterrupted()) {
                for (int i = 0; i < 10; i++) {
                    if (!Thread.currentThread().isInterrupted()) {
                        Thread.sleep(t);
                        log.info("嵌套子线程 doing:" + i);
                    } else {
                        // 核心代码:必须抛异常来终止嵌套子线程
                        log.info("嵌套子线程:异常结束");
                        throw new RuntimeException("嵌套子线程:异常结束");
                    }
                }
            }
        } catch (Exception e) {
            log.info("嵌套子线程: " + Thread.currentThread().getName() + "异常:" + e.getMessage());
            Thread.currentThread().interrupt();
        }

    }
}
