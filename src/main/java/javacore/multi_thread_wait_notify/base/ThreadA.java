package javacore.multi_thread_wait_notify.base;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-05
 */
public class ThreadA {
    public static void main(String[] args) {
        ThreadB b = new ThreadB();
        b.start();

        synchronized (b) {
            try {
                System.out.println("Waiting for b to complete...");
                b.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Total is: " + b.total);
        }
    }
}

