package javacore.MultiThread.ThreadPoolTimeOut_Block_No;


/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-08-22
 */

public class WorkerThread implements Runnable {
    private String command;

    private long timeout;


    public WorkerThread(String command, long timeout) {
        this.command = command;
        this.timeout = timeout;
    }

    @Override
    public void run() {
        try {
            System.out.println("子线程-嵌套线程: " + Thread.currentThread().getName() + " Start. Command = " + command + ",timeout is :" + timeout);
            for (int i = 0; i < Long.MAX_VALUE; i++) {
                if (!Thread.currentThread().isInterrupted()) {
                    // TODO
                    if (i % 1000 == 0) {
                        System.out.println("" + i);
                    }
                }else {
                    // 核心代码
                    throw new RuntimeException("通过抛异常来终止-嵌套子线程结束");
                }

            }
            System.out.println("子线程-嵌套线程: " + Thread.currentThread().getName() + " End.");
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }

    }
}
