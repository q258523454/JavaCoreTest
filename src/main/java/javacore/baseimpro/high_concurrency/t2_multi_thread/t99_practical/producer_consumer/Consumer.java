package javacore.baseimpro.high_concurrency.t2_multi_thread.t99_practical.producer_consumer;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-05
 */
public class Consumer implements Runnable {

    private Broker broker;

    public Consumer(Broker broker) {
        this.broker = broker;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = broker.getMessage();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}