package javacore.baseimpro.high_concurrency.t2_multi_thread.t99_practical.producer_consumer;


import java.util.Date;
import java.util.UUID;
import java.util.Vector;

public class Broker {

    private final Object producerSyn = new Object();

    private final Object consumerSyn = new Object();

    private static final int MAXQUEUE = 5;

    private Vector<String> messages = new Vector<>(5);

    /**
     * 生产 message
     */
    public void putMessage() throws InterruptedException {
        synchronized (producerSyn) {
            if (messages.size() >= MAXQUEUE) {
                System.out.println("message full");
                Thread.sleep(1000);
                return;
            }
            messages.addElement(UUID.randomUUID().toString().substring(0, 3) + ":" + new Date().toString());
            System.out.println("put,size=" + messages.size());
        }
    }

    /**
     * 消费 message
     */
    public String getMessage() throws InterruptedException {
        synchronized (consumerSyn) {
            if (messages.size() <= 0) {
                System.out.println("message empty.");
                Thread.sleep(1000);
                return "";
            }
            String message = messages.firstElement();
            // 模拟业务操作
            Thread.sleep(500);
            messages.removeElement(message);
            System.out.println("get a message,size=" + messages.size());
            return message;
        }
    }

}
