package javacore.multi_thread.multi_thread_base;

/**
 * Created by
 *
 * @author :   zj
 * @date :   2018-08-20
 */

public class Base4_Synchronized implements Runnable {
    public synchronized void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " synchronized loop " + i);
        }
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

        // 类的静态方法一定是类锁(因为此时对象还未生成)
        public synchronized static void insert1(String name) {
            System.out.println(name + "执行类线程锁 .. BEGIN");
            System.out.println(name + "执行类线程锁 .. END");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Base4_Synchronized test = new Base4_Synchronized(); // 创建对象

        // 1.同一个对象的两个线程, 在run()存在互斥锁, 因为一个对象只有一把锁, 一个线程在用, 其他的线程必须等待, 但是可以访问非synchronized方法
        Thread ta = new Thread(test, "A1");
        Thread tb = new Thread(test, "A2");
        ta.start();
        tb.start();
        Thread.sleep(500);
        System.out.println("----------");

        // 2.不同对象, 访问synchronized方法是不存在互斥的, 因为每个对象有各自的锁
        Base4_Synchronized test1_a = new Base4_Synchronized();
        Base4_Synchronized test1_b = new Base4_Synchronized();
        Thread tt1 = new Thread(test1_a, "A");
        Thread tt2 = new Thread(test1_b, "B");
        tt1.start();
        tt2.start();
        Thread.sleep(500);
        System.out.println("----------");


        // 3.类synchronized测试, 类线程锁和对象线程锁 互不影响, 但是同类和同对象, 仍存在互斥(Synchronized)
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


}


