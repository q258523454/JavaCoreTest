package javacore.multi_thread_treadlocal;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-05
 */
public class ThreadLocalExample {

    public static class MyRunnable implements Runnable {

        int local = 0;
        public static int global = 0;
        private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

        @Override
        public void run() {
            synchronized (this) {
                if (0 == local) {
                    local = (int) (Math.random() * 100D);
                }
                if (0 == global) {
                    global = (int) (Math.random() * 100D);
                }
                if (null == threadLocal.get()) {
                    threadLocal.set((int) (Math.random() * 100D));
                }
                System.out.println("local:" + local);
                System.out.println("global:" + global);
                System.out.println("threadLocal:" + threadLocal.get());
            }
        }
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable);
        Thread thread2 = new Thread(myRunnable);
        thread1.start();
        thread2.start();
    }

}