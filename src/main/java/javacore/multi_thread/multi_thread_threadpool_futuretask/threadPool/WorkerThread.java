package javacore.multi_thread.multi_thread_threadpool_futuretask.threadPool;


/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-08-22
 */

public class WorkerThread implements Runnable {
    private String command;

    public WorkerThread(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Command = " + command);
        processCommand(Thread.currentThread().getName(), command);
        System.out.println(Thread.currentThread().getName() + " End.");
    }

    private void processCommand(String threadName, String command) {
        System.out.println("新开线程" + threadName + ":, 准备进行操作:" + command);
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
