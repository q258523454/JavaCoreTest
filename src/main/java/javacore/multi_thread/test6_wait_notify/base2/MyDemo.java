package javacore.multi_thread.test6_wait_notify.base2;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-05
 */
public class MyDemo {
    private volatile boolean flag = false;

    public synchronized boolean getFlag() {
        System.out.println(Thread.currentThread().getName() + "开始执行...");
        if (this.flag != true) {
            try {
                wait(); // wait()操作后，会暂时释放synchronized的同步锁，等notify()触发后，又会重拾起该锁，保证线程同步
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "执行结束...");
        return flag;
    }

    public synchronized void setFlag(boolean flag) {
        this.flag = flag;
//         notify(); // notity()释放一个进程(注意:只会释放第一个线程)
        notifyAll(); // 逐一通知进程
        try {
            System.out.println("notify()触发(不会立马释放锁),等待...");
            Thread.sleep(1000);
            System.out.println("notify()触发(不会立马释放锁),直到notify()所在的synchronized块全部执行完毕后才会释放.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        MyDemo myDemo = new MyDemo();
        Runnable target1 = new Runnable() {
            @Override
            public void run() {
                myDemo.getFlag();
            }
        };

        Runnable target2 = new Runnable() {
            @Override
            public void run() {
                myDemo.setFlag(true);
            }
        };

        new Thread(target1).start();
        new Thread(target1).start();
        new Thread(target1).start();
        new Thread(target1).start();
        new Thread(target2).start(); // notity()释放一个进程(注意:只会释放第一个线程)
    }
}
