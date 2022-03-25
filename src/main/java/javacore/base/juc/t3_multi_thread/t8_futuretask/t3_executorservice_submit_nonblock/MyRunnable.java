package javacore.base.juc.t3_multi_thread.t8_futuretask.t3_executorservice_submit_nonblock;


import lombok.AllArgsConstructor;

/**
 * Created by
 *
 * @date :   2018-08-22
 */

@AllArgsConstructor
public class MyRunnable implements Runnable {
    private String command;

    private long timeout;

    @Override
    public void run() {
        try {
            System.out.println("嵌套子线程: " + Thread.currentThread().getName() + " Start. Command = " + command + ",timeout is :" + timeout);
            // 10个线程,平均每个线程等待时间
            long t = timeout / 10;
            while (!Thread.currentThread().isInterrupted()) {
                for (int i = 0; i < 10; i++) {
                    if (!Thread.currentThread().isInterrupted()) {
                        Thread.sleep(t);
                        System.out.println("嵌套子线程 doing:" + i);
                    } else {
                        // 核心代码:必须抛异常来终止嵌套子线程
                        System.out.println("嵌套子线程:异常结束");
                        throw new RuntimeException("嵌套子线程:异常结束");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("嵌套子线程: " + Thread.currentThread().getName() + "异常:" + e.getMessage());
            Thread.currentThread().interrupt();
        }

    }
}
