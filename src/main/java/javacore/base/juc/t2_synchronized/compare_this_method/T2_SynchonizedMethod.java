package javacore.base.juc.t2_synchronized.compare_this_method;

import lombok.extern.slf4j.Slf4j;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-27
 */

@Slf4j
public class T2_SynchonizedMethod {
    public synchronized void started() throws InterruptedException {
        // 执行其它逻辑消耗时间
        Thread.sleep(20);
    }
}
