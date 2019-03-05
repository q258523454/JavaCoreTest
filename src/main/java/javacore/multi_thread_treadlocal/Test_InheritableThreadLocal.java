package javacore.multi_thread_treadlocal;

import java.util.Date;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-05
 */
public class Test_InheritableThreadLocal {

    public static MyInheritableThreadLocal tl = new MyInheritableThreadLocal();

    // InheritableThreadLocal可以取到父线程的ThreadLocal类的变量
    static public class MyInheritableThreadLocal extends InheritableThreadLocal {
        @Override
        protected Object initialValue() {
            return new Date().getTime();
        }

        @Override
        protected Object childValue(Object parentValue) {
            return super.childValue(parentValue) + "我是子线程";
        }
    }

    static public class MyThread extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 2; i++) {
                    System.out.println("在[子线程]中取值=" + Test_InheritableThreadLocal.tl.get());
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 2; i++) {
                Test_InheritableThreadLocal.tl.set(new Date().getTime());
                System.out.println("在[主线程]中取值=" + Test_InheritableThreadLocal.tl.get());
                Thread.sleep(100);
            }
            Thread.sleep(500);
            MyThread t = new MyThread();
            t.start();
            t.join(); // 等待线程执行完毕
            System.out.println(Test_InheritableThreadLocal.tl.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
