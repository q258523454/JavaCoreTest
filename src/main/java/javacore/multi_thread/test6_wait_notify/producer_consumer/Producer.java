package javacore.multi_thread.test6_wait_notify.producer_consumer;

import java.util.Date;
import java.util.UUID;
import java.util.Vector;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-05
 */
public class Producer extends Thread {
    static final int MAXQUEUE = 5;
    private Vector messages = new Vector();

    @Override
    public void run() {
        try {
            while (true) {
                putMessage();
                //sleep(5000);
            }
        } catch (InterruptedException e) {
        }
    }

    private synchronized void putMessage() throws InterruptedException {
        while (messages.size() == MAXQUEUE) {
            wait(); // 等待消费者消费
        }
        messages.addElement(UUID.randomUUID().toString().substring(1, 3) + ":" + new Date().toString());
        System.out.println("put message");
        notify();
    }

    // Called by Consumer
    public synchronized String getMessage() throws InterruptedException {
        notify(); // 消费者即将消费, 对象锁并不释放, 也就是说同对象的putMessage还不能执行, 必须等该方法执行完毕. 即要当消费者消费完毕.
        System.out.println("notify()并不立马释放synchronized锁--begin");
        Thread.sleep(2000);
        System.out.println("notify()并不立马释放synchronized锁--end");
        while (messages.size() == 0) {
            wait(); // 执行到wait()会立马释放synchronized锁,进入sleep状态
        }
        String message = (String) messages.firstElement();
        messages.removeElement(message);
        return message;
    }
}
