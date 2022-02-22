package javacore.baseimpro.high_concurrency.t2_multi_thread.t4_reentrantlock;

import lombok.extern.slf4j.Slf4j;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-06
 */
@Slf4j
public class T1_CannotReentryRun {

    T1_CannotReentry cannotLock = new T1_CannotReentry();

    public void firstLock() {
        try {
            // 上锁
            cannotLock.lock();
            log.info("首次上锁");
            // 无法重入, 第一次上锁还没有释放
            doSecondLock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            cannotLock.unlock();
        }
    }

    public void doSecondLock() {
        try {
            log.info("准备进行2次上锁");
            cannotLock.lock();
            log.info("2次上锁完成");
            cannotLock.unlock();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        T1_CannotReentryRun test = new T1_CannotReentryRun();
        // 下面将因为无法重入,导致死循环
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.firstLock();
            }
        }).start();
    }

}