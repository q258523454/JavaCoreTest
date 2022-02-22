package javacore.baseimpro.high_concurrency.t2_multi_thread.t6_wait_notify.t1_locksupport;

import lombok.SneakyThrows;

import java.util.concurrent.locks.LockSupport;

public class LockSupportPark {


    @SneakyThrows
    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread run");
                /**
                 * LockSupport 是JUC线程并发包的基础类之一, C/C++实现
                 */
                LockSupport.park();
                System.out.println("Thread top");
            }
        });

        thread.start();
        Thread.sleep(2000);
        // 唤醒指定线程
        LockSupport.unpark(thread);


    }
}
