package javacore.baseimpro.high_concurrency.t2_multi_thread.t3_synchronized.compare;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-27
 */
public class T2_SynchonizedMethod {
    public synchronized void started() throws InterruptedException {
        // 执行其它逻辑消耗时间
        Thread.sleep(10);
        System.out.println("我运行使用了 10 ms");
    }
}
