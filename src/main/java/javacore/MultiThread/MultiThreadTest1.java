package javacore.MultiThread;

/**
 * Created by
 *
 * @author :   zj
 * @date :   2018-08-20
 */

public class MultiThreadTest1 implements Runnable {
    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " synchronized loop " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MultiThreadTest1 test = new MultiThreadTest1(); // 创建对象

        // 1.同一个对象的两个线程, 在run()存在互斥锁, 因为一个对象只有一把锁, 一个线程在用, 其他的线程必须等待, 但是可以访问非synchronized方法
        Thread ta = new Thread(test, "A1");
        Thread tb = new Thread(test, "A2");
        ta.start();
        tb.start();
        Thread.sleep(500);
        System.out.println("----------");

        // 2.不同对象, 访问synchronized方法是不存在互斥的, 因为没个对象有各自的锁
        MultiThreadTest1 test1_a = new MultiThreadTest1();
        MultiThreadTest1 test1_b = new MultiThreadTest1();
        Thread tt1 = new Thread(test1_a, "A");
        Thread tt2 = new Thread(test1_b, "B");
        tt1.start();
        tt2.start();
        Thread.sleep(500);
        System.out.println("----------");


        // 3.类synchronized测试, 类线程锁和对象线程锁 互不影响
        final InsertData insertData = new InsertData();
        new Thread() {
            @Override
            public void run() {
                insertData.insert("A");
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                insertData.insert1("B");
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                insertData.insert1("C");
            }
        }.start();

    }
    static class InsertData {
        public synchronized void insert(String name) {
            System.out.println(name+"执行对象线程锁.. BEGIN");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name+"执行对象线程锁.. END");
        }

        public synchronized static void insert1(String name) {
            System.out.println(name + "执行类线程锁 .. BEGIN");
            System.out.println(name + "执行类线程锁 .. END");
        }
    }

}


