package javacore.baseimpro.high_concurrency.t2_multi_thread.t4_reentrantlock.base_test;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:
 * @Author: zhangj
 * @Date: 2019-12-20 17:20
 * @Modify:
 */
@Slf4j
public class AccountErrorExample implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(AccountErrorExample.class);

    /**
     * 账户上默认有100元
     */
    private int money = 100;

    // 取钱
    public void draw() throws InterruptedException {
        // 当前余额
        int balance = money;
        if (balance > 0) {
            Thread.sleep(1000);
            // 取走100元
            money = money - 100;
            log.info("当前余额为" + balance + "元，" + Thread.currentThread().getName() + "取走100元，还剩" + money + "元");
        } else {
            log.info("余额不足,{}取钱失败", Thread.currentThread().getName());
        }
    }

    @Override
    public void run() {
        try {
            draw();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
