package javacore.base.juc.t2_synchronized;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-27
 */
@Slf4j
public class Synchronized_Class_This {
    /***
     * Synchronized
     * 原理: 基于 JVM 底层 monitor(Mutex Lock互斥锁) 来进行线程同步实现. 对象monitor=0则获取锁,有锁则+1,退出则-1.是可重入锁.
     *
     * Synchronized上锁方式:
     *      1.this:对象锁(实例锁)
     *      2.Class:类锁
     *      synchronized 锁住的是一个对象(实例)或者类，而不是方法或者代码段。
     *      同一个对象的对象锁被lock, 该对象的所有synchronized[方法级]都互斥;
     *      同一类的类锁被lock, 该类的所有synchronized[类级别]都互斥;
     *      但是对象锁和类锁互不影响
     *
     * 锁类型和升级:
     *      锁升级: 锁的升级是不可逆的,特殊:偏向锁是可以转换成无锁状态的.
     *             偏向锁->轻量锁->(自旋锁膨胀)->重量锁 (JDK1.6之前都是重量锁,效率低)
     *
     *      自旋锁: 一个线程尝试获取锁时,如果已被占用,就循环检测一定次数,而不是进入线程挂起或睡眠状态. 因为用户态和核心态的切换开销很大.
     *             自旋一定次数后,一般就会触发锁膨胀.
     *      锁类型：
     *       1.偏向锁: 认为大部分情况下是同一个线程获取锁,JDK优化了同一个线程获取锁的开销.
     *                偏向锁机制是单线程使用的机制,在多线程环境下(即线程A尚未执行完同步代码块，线程B发起了申请锁的申请),则一定会转化为轻量级锁或者重量级锁。
     *                注意是线程B是申请锁,并不存在AB线程竞争锁.
     *                偏向锁思想:一旦线程第一次获得了监视对象,之后让监视对象'偏向'这个线程.之后的多次调用则可以避免CAS(指令)操作.
     *                         说白了就是置个变量,如果发现为true则无需再走各种加锁/解锁流程。
     *                问: 为什么避免CAS操作能提高效率?
     *                答: CAS(指令)会导致CPU总线同步,即'Cache一致性',这个操作会导致本地延迟。
     *
     *                问: 升级偏向锁条件?
     *                答: 只要有其他线程申请锁.
     *
     *       2.轻量锁: 认为竞争的程度很轻. 另外一个线程在申请锁的时候, 通过'自旋'获取.
     *                问: 升级重量锁条件?
     *                答: ①两个线程的自旋次数超过 或者 ②有3个或以上的线程同时竞争锁.
     *
     *       3.重量锁: 锁的竞争消耗最大,都是从用户态转换成内核态.重量级锁把除了拥有锁的线程都阻塞，防止CPU空转
     *
     */
    @SneakyThrows
    public void test1() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                log.info(Thread.currentThread().getName() + " : " + i);
                Thread.sleep(500);
            }
        }
    }

    // 对象锁A
    @SneakyThrows
    public synchronized void instanceSyncA() {
        for (int i = 0; i < 5; i++) {
            log.info(Thread.currentThread().getName() + " : " + i);
            Thread.sleep(500);
        }
    }

    // 对象锁B
    @SneakyThrows
    public synchronized void instanceSyncB() {
        for (int i = 0; i < 5; i++) {
            log.info(Thread.currentThread().getName() + " : " + i);
            Thread.sleep(500);
        }
    }

    // 类锁A
    @SneakyThrows
    public static synchronized void classSyncA() {
        for (int i = 0; i < 5; i++) {
            log.info(Thread.currentThread().getName() + " : " + i);
            Thread.sleep(500);
        }
    }

    // 类锁B
    @SneakyThrows
    public static synchronized void classSyncB() {
        for (int i = 0; i < 5; i++) {
            log.info(Thread.currentThread().getName() + " : " + i);
            Thread.sleep(500);
        }
    }

    public static void main(String[] args) {
        final Synchronized_Class_This myt1 = new Synchronized_Class_This();
        final Synchronized_Class_This instanceX = new Synchronized_Class_This();
        final Synchronized_Class_This instanceY = new Synchronized_Class_This();

        // ------------ 1.同一个实例, 所有的synchronized方法(对象锁), 互斥 ------------
        // Thread test1 = new Thread(() -> instanceX.instanceSyncA(), "test1");
        // Thread test2 = new Thread(() -> instanceX.instanceSyncB(), "test2");

        // ------------ 2.不同的实例，同一个synchronized方法(对象锁), 互不影响 ------------
        // Thread test1 = new Thread(() -> instanceX.instanceSyncA(), "test1");
        // Thread test2 = new Thread(() -> instanceY.instanceSyncA(), "test2");

        // ------------ 3.不同的实例，相同的static synchronized方法(类锁), 互斥 ------------
        // Thread test1 = new Thread(() -> Synchronized_Class_This.classSyncA(), "test1");
        // Thread test2 = new Thread(() -> Synchronized_Class_This.classSyncA(), "test2");

        // ------------ 4.同一个类的不同的实例，不同的static synchronized方法(类锁), 互斥 ------------
        // Thread test1 = new Thread(() -> Synchronized_Class_This.classSyncA(), "test1");
        // Thread test2 = new Thread(() -> Synchronized_Class_This.classSyncB(), "test2");

        // ------------ 5.对象锁和类锁互不影响, 即对象锁和类锁属于不同的管理区域 ------------
        Thread test1 = new Thread(() -> instanceX.instanceSyncA(), "test1");
        Thread test2 = new Thread(() -> Synchronized_Class_This.classSyncA(), "test2");

        test1.start();
        test2.start();
    }

}
