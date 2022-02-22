package javacore.baseimpro.high_concurrency.t2_multi_thread.t4_reentrantlock.base_test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:
 * @Author: zhangj
 * @Date: 2019-12-20 17:28
 * @Modify:
 */
public class AccountReentrantLockRun {
    private static final Logger logger = LoggerFactory.getLogger(AccountReentrantLockRun.class);

    public static void main(String[] args) {
        AccountReentrantLock accountImpro = new AccountReentrantLock();
        Thread wife = new Thread(accountImpro, "wife");
        Thread husband = new Thread(accountImpro, "husband");
        // 妻子取钱
        wife.start();
        // 丈夫取钱
        husband.start();
        logger.info(Thread.currentThread().getName()+"执行完成.");
    }


}
