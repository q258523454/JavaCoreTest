package javacore.base.jdk.threadlocal.base;

public class RunTest {

    /**
     *  概念:
     *   Thread.ThreadLocal.ThreadLocalMap 存的 <ThreadLocal 弱引用,value>
     *   每个线程都维护了自己的一个 ThreadLocalMap.
     *   ThreadLocal 仅仅是个工具类，而真正存储独立变量副本是 Thread 类。
     *   ThreadLocal 只是提供了存储独立变量副本的数据结构 static ThreadLocalMap 和操作
     *
     *  脏数据问题:
     *   线程复用导致产生脏数据。由于线程池会复用 Thread 对象，进而 Thread 对象中的 threadLocals 也会被复用，
     *   导致Thread对象在执行其他任务时通过get()方法获取到之前任务设置的数据，从而产生脏数据。
     *   解决: 线程执行前重新调用set()
     *
     *  内存泄漏问题:
     *   结构：ThreadLocalMap.Entry<ThreadLocal弱引用,value>
     *   由于 value 存在强关联 Thread-> ThreadLocal.ThreadLocalMap -> Entry<null,value>,
     *   就是说ThreadLocalMap的生命周期跟Thread一样长.
     *   因此不管 ThreadLocal 是弱引用还是强引用, 只要 Thread 线程不退出, 这个 value 值就会一直存在.
     *   弱引用并不解决内存泄露问题,只是多一层保障, 能让 ThreadLocal 不存在强引用的情况下能回收key, 进而
     *   能在下一次 get/set/remove(这些方法都有判断 key<弱引用>是否等于 null) 的时候回收value.
     *   解决: 线程执行完后调用remove()
     *
     *  总结:
     *   Entry的弱引用机制不是导致 ThreadLocal 内存泄漏的原因.它只是一个保障.
     */
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThreadLocal());
        Thread thread2 = new Thread(new MyThreadLocal());
        thread1.start();
        thread2.start();
    }
}