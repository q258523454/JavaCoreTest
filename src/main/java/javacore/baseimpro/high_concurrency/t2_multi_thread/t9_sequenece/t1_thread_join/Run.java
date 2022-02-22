package javacore.baseimpro.high_concurrency.t2_multi_thread.t9_sequenece.t1_thread_join;

import lombok.SneakyThrows;

public class Run {

    /**
     * Thread.join()
     */
    @SneakyThrows
    public static void main(String[] args) {
        // 创建三个线程 A,B,C
        Thread threadA = new Thread(() -> System.out.println("A"), "A");
        Thread threadB = new Thread(() -> System.out.println("B"), "B");
        Thread threadC = new Thread(() -> System.out.println("C"), "C");

        // 使用 Thread.join() 等待线程执行完毕, 这种方式不优雅
        threadA.start();
        threadA.join();

        threadB.start();
        threadB.join();

        threadC.start();
        threadC.join();

        System.exit(0);
    }
}
