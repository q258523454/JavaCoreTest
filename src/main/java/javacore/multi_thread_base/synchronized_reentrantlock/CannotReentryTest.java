package javacore.multi_thread_base.synchronized_reentrantlock;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-06
 */
public class CannotReentryTest {

    CannotReentry lock = new CannotReentry();

    public void print() {
        try {
            lock.lock(); // 上锁
            System.out.println("print....");
            doAdd();    //  无法重入, 第一次上锁还没有释放
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void doAdd() {
        try {
            lock.lock();
            System.out.println("doAdd....");
            lock.unlock();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CannotReentryTest test = new CannotReentryTest();
        // 下面将因为无法重入,导致死循环
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                test.print();
            }
        }).start();
    }

}