package javacore.multi_thread;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-08-22
 */


class Base2_OnlyThread extends Thread {  //继承Thread
    Base2_OnlyThread(String name) {
        super(name);
    }

    //复写其中的run方法
    public void run() {
        for (int i = 1; i <= 20; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ",i=" + i);
        }
    }

    static class RunDemo {
        public static void main(String[] args) {
            //创建两个线程任务
            Base2_OnlyThread d = new Base2_OnlyThread("a");
            Base2_OnlyThread d2 = new Base2_OnlyThread("b");
            Base2_OnlyThread d3 = new Base2_OnlyThread("c");
            d.run();    // 没有开启新线程, 在主线程调用run方法
            d2.start(); // 开启一个新线程，新线程调用run方法//d.getName();
            d3.start();
            System.out.println("主线程结束");
        }
    }
}
