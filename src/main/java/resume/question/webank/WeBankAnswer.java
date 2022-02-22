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
public class WeBankAnswer {

    public static WeBankAnswer weBank = null;
    private static ThreadLocal<Integer> count = new ThreadLocal<>();
    private Lock lock = new ReentrantLock();

    public WeBankAnswer() {
        System.out.println("set count = 0");
        count.set(0);
    }

    public static WeBankAnswer getInstance() {
        if (null == weBank) {
            synchronized (WeBankAnswer.class) {
                if (null == weBank) {
                    System.out.println("首次创建.");
                    weBank = new WeBankAnswer();
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

    // count 是ThreadLocal<T> 说明是线程变量, 1. 没有初始化; 2.代码是无法实现统计功能的
    public static void main(String[] args) throws InterruptedException {

        /**
         * 分析:
         * 1.ThreadLocal是线程内变量, ThreadLocal.get()以当前线程this作为key存入
         * 2.单例模型,构造函数只会初始化一次
         * 答案: 第二个Thread会报空指针错位
         * 问题: 两次新开线程, 那么 ThreadLocal 分别是两个不同的对象, 由于单例模型只初始化了一次 ThreadLocal
         */
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                WeBankAnswer.getInstance().incr("a");
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                WeBankAnswer.getInstance().incr("b");
            }
        });

        a.start();
        b.start();
    }

}
