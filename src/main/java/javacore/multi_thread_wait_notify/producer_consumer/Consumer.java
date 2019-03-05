package javacore.multi_thread_wait_notify.producer_consumer;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-05
 */
public class Consumer extends Thread {

    Producer producer;

    Consumer(Producer p) {
        producer = p;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = producer.getMessage();
                System.out.println("Got message: " + message);
//                sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {

        Producer producer = new Producer();
        producer.start();

        Consumer consumer = new Consumer(producer);
        consumer.start();
    }
}