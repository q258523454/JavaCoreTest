package javacore.base.juc.t2_synchronized.compare_this_method;

import lombok.extern.slf4j.Slf4j;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-27
 */
@Slf4j
public class T1_SynchonizedThis {
    /**
     * 总结: 能同步代码块的就同步代码块, 尽量别直接同步方法
     */
    public void started() throws InterruptedException {
        // 同步代码块(从这里开始同步), 与在方法上加 synchronized 不一样,这样效率更高
        synchronized (this) {
            Thread.sleep(20);
        }
    }
}
