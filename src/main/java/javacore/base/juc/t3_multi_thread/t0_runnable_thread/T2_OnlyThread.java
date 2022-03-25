package javacore.base.juc.t3_multi_thread.t0_runnable_thread;


/**
 * Created by
 *
 * @date :   2018-08-22
 */


class T2_OnlyThread extends Thread {  //继承Thread
    T2_OnlyThread(String name) {
        super(name);
    }

    // 复写其中的run方法
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ",i=" + i);
        }
    }

    public static class RunDemo {
        public static void main(String[] args) {
            //创建两个线程任务
            T2_OnlyThread d = new T2_OnlyThread("主线程");
            T2_OnlyThread d2 = new T2_OnlyThread("子线程A");
            T2_OnlyThread d3 = new T2_OnlyThread("子线程B");
            d.run();    // 没有开启新线程, 在主线程调用run方法
            d2.start(); // 开启一个新线程，新线程调用run方法//d.getName();
            d3.start();
            System.out.println("主线程结束");
        }
    }
}
