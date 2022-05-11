package javacore.base.juc.t3_multi_thread.t1_reentrantlock.base_test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:
 * @Author: zhangj
 * @Date: 2019-12-20 17:28
 * @Modify:
 */
public class Account_Success_Run {
    private static final Logger logger = LoggerFactory.getLogger(Account_Success_Run.class);

    public static void main(String[] args) {
        Account_Success accountImpro = new Account_Success();
        Thread wife = new Thread(accountImpro, "wife");
        Thread husband = new Thread(accountImpro, "husband");
        // 妻子取钱
        wife.start();
        // 丈夫取钱
        husband.start();
        logger.info(Thread.currentThread().getName()+"执行完成.");
    }


}
