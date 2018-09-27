package javacore.MultiThread.ThreadPoolTimeOut_Block;


/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-08-22
 */

public class WorkerThread implements Runnable {
    private String command;

    private long timeout;

    public WorkerThread(String command,long timeout) {
        this.command = command;
        this.timeout = timeout;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Command = " + command + ",timeout is :" + timeout);
        processCommand(Thread.currentThread().getName(), command);
        System.out.println(Thread.currentThread().getName() + " End.");
    }

    private void processCommand(String threadName, String command) {
        System.out.println("线程 " + threadName + ":, 正在进行操作:" + command);
        try {
            Thread.sleep(this.timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
