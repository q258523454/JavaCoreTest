package javacore.base.t2_collection.queue.blocking_queue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    protected BlockingQueue queue = null;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            System.out.println("消费1:" + queue.take());
            System.out.println("消费2:" + queue.take());
            System.out.println("消费3:" + queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
