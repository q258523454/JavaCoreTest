package javacore.multi_thread.test3_synchronize_location_compare;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-27
 */
public class SynchonizedMethod {
    public synchronized void started() throws InterruptedException {
        Thread.sleep(10);//执行其它逻辑消耗时间
        System.out.println("我运行使用了 10 ms");
    }
}
