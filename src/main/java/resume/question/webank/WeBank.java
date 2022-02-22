package resume.question.webank;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created By
 *
 * @date :   2018-09-27
 */


/***
 *  下面代码用来统计某个系统的所有用户登录, 多线程单例模式运行, 会出现什么问题？
 */
public class WeBank {

    public static WeBank weBank = null;
    private ThreadLocal<Integer> count = new ThreadLocal<>();
    private Lock lock = new ReentrantLock();

    public WeBank() {
        System.out.println("set count = 0");
        count.set(0);
    }

    public static WeBank getInstance() {
        if (null == weBank) {
            synchronized (WeBank.class) {
                if (null == weBank) {
                    System.out.println("首次创建.");
                    weBank = new WeBank();
                }
            }
        }
        System.out.println("返回实例.");
        return weBank;
    }

    public int get() {
        return count.get();
    }

    public void incr(String userId) {
        int currCount = 0;
        lock.lock();
        currCount = count.get() + 1;
        count.set(currCount);
        lock.unlock();
        System.out.println("userId=" + userId + ",访问次数:" + currCount);
    }

    public static void main(String[] args) throws InterruptedException {

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                WeBank.getInstance().incr("a");

            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                WeBank.getInstance().incr("b");
            }
        });

        a.start();
        b.start();
    }

}
