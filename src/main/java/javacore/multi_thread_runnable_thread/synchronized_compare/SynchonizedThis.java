package javacore.multi_thread.synchronized_compare;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-27
 */
public class SynchonizedThis {
    public void started() throws InterruptedException {
        Thread.sleep(100);//1
        synchronized (this) { //同步代码块
            //Thread.sleep(100);//2
            System.out.println("我运行使用了 10 ms");
        }
    }
}
