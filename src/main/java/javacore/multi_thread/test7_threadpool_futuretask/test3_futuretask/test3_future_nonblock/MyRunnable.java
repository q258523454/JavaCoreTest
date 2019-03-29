package javacore.multi_thread.test7_threadpool_futuretask.test3_futuretask.test3_future_nonblock;


/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-08-22
 */

public class MyRunnable implements Runnable {
    private String command;

    private long timeout;


    public MyRunnable(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        try {
            System.out.println("子线程-嵌套线程: " + Thread.currentThread().getName() + " Start. Command = " + command + ",timeout is :" + timeout);
            for (int i = 0; i < 10; i++) {
                if (!Thread.currentThread().isInterrupted()) {
                    Thread.sleep(100);
                    System.out.println("子线程-嵌套线程doing:" + i);
                }else {
                    // 核心代码
                    throw new RuntimeException("通过抛异常来终止-嵌套子线程结束");
                }
            }
        } catch (Exception e) {
            System.out.println("子线程-嵌套线程: " + Thread.currentThread().getName() + " 结束.");
            Thread.currentThread().interrupt();
        }

    }
}
