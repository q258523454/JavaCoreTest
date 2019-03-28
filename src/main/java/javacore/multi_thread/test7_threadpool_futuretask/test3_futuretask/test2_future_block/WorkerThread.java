package javacore.multi_thread.test7_threadpool_futuretask.test3_futuretask.threadPoolTimeOut_Block;


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
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " 开始. Command = " + command + ",timeout is :" + timeout);
        System.out.println("线程 " + threadName + ",正在进行操作:" + command);
        try {
            Thread.sleep(timeout);
        } catch (Exception e) {
            System.err.println("异常:线程中断");
        }
        System.out.println(Thread.currentThread().getName() + " 结束.");
    }

}
