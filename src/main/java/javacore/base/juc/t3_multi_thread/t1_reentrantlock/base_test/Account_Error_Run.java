package javacore.base.juc.t3_multi_thread.t1_reentrantlock.base_test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:
 * @Author: zhangj
 * @Date: 2019-12-20 17:24
 * @Modify:
 */
public class Account_Error_Run {
    private static final Logger logger = LoggerFactory.getLogger(Account_Error_Run.class);

    public static void main(String[] args) {
        Account_Error account = new Account_Error();
        Thread wife = new Thread(account, "wife");
        Thread husband = new Thread(account, "husband");
        // 妻子取钱
        wife.start();
        // 丈夫取钱(本应该失败,却成功)
        husband.start();
    }
}
