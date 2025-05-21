package javacore.base.juc.t3_multi_thread.t3_wait_notify.t2_locksupport;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;


@Slf4j
public class LockSupportPark {

    static class MyPark implements Runnable {

        @SneakyThrows
        @Override
        public void run() {
            log.info(Thread.currentThread() + ":Thread run");
            Thread.sleep(1000);

            /*
             * LockSupport 是JUC线程并发包的基础类之一, C/C++实现
             */
            LockSupport.park();
            log.info(Thread.currentThread() + ":Thread top");
        }
    }


    /**
     * LockSupport 与 wait/notify 区别?
     * LockSupport 不需要提前获取锁
     * LockSupport 可以指定唤醒线程
     * LockSupport 可以提前产生凭证(PV信号量), 即可以 先 unpark 再 park.
     */
    @SneakyThrows
    public static void main(String[] args) {

        // 一: 先 park 再 unpark.
        Thread thread = new Thread(new MyPark());
        thread.start();
        Thread.sleep(2000);
        // unpark
        LockSupport.unpark(thread);

        log.info("-------------------------");

        // 二: 先 unpark 再 park.
        Thread thread2 = new Thread(new MyPark());
        // park 线程前,让 unpark 先执行. 这里并不会阻塞, LockSupport 是PV信号量模式, 可以提前产生凭证.
        thread2.start();
        // unpark 先执行, 相当于信号量-提前置1,下次park会直接消费这个凭证
        LockSupport.unpark(thread2);
    }

}
