package javacore.multi_thread.test6_wait_notify.base3;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-05
 */
public class MyDemo {
    public synchronized boolean setWait() {
        System.out.println(Thread.currentThread().getName() + "开始执行...");
        try {
            wait(); // wait()操作后，会暂时释放synchronized的同步锁，等notify()触发后，又会重拾起该锁，保证线程同步
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "执行结束...");
        return true;
    }

    public synchronized void freeWait(boolean flag) {
        notify(); // notity()释放一个进程(注意:只会释放第一个线程)
        try {
            System.out.println("notify()触发(不会立马释放锁),等待...");
            Thread.sleep(1000);
            System.out.println("notify()触发(不会立马释放锁),直到notify()所在的synchronized结束后才会释放.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        MyDemo myDemo = new MyDemo();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                myDemo.setWait();
            }
        });
        // 当线程呈wait状态时，对线程对象调用interrupt方法会出现InterrupedException异常
        thread.start();
        thread.interrupt();
    }
}
