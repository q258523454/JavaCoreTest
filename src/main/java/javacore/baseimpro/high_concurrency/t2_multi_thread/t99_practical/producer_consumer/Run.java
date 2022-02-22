package javacore.baseimpro.high_concurrency.t2_multi_thread.t99_practical.producer_consumer;

public class Run {
    public static void main(String args[]) throws InterruptedException {
        Broker broker = new Broker();
        Producer producer = new Producer(broker);
        Consumer consumer = new Consumer(broker);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
