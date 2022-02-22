package javacore.baseimpro.high_concurrency.t2_multi_thread.t99_practical.producer_consumer;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-05
 */
public class Producer implements Runnable {

    private Broker broker;

    public Producer(Broker broker) {
        this.broker = broker;
    }

    @Override
    public void run() {
        try {
            while (true) {
                broker.putMessage();
            }
        } catch (InterruptedException e) {
            // TODO
        }
    }


}
