package javacore.base.juc.t3_multi_thread.t4_reentrantlock.base_test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: zhangj
 * @Date: 2019-12-20 17:20
 * @Modify:
 */
@Slf4j
public class AccountReentrantLock implements Runnable {

    /**
     * 重入锁:允许并发获取锁
     */
    private ReentrantLock lock = new ReentrantLock();
    /**
     * 账户上默认有100元
     */
    private int money = 100;

    /**
     * 取钱
     */
    public void draw() throws InterruptedException {
        lock.lock();
        try {
            log.info("{}开始取钱", Thread.currentThread().getName());
            int balance = money; //当前余额
            if (balance > 0) {
                Thread.sleep(1000);
                money = money - 100;   //取走100元
                log.info("当前余额为" + balance + "元，" + Thread.currentThread().getName() + "取走100元，还剩" + money + "元");
            } else {
                log.info("余额不足,{}取钱失败", Thread.currentThread().getName());
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            lock.unlock();
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
