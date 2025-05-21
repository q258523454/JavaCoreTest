package resume.onlineAC.z_other.threadlocal;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/***
 *  下面代码用来统计某个系统的所有用户登录, 多线程单例模式运行, 会出现什么问题？
 */
public class LoginCountAnswer {

    public static volatile LoginCountAnswer loginCount = null;


    private static final ThreadLocal<Integer> COUNT = new ThreadLocal<>();

    private final Lock lock = new ReentrantLock();

    public LoginCountAnswer() {
        System.out.println("set count = 0");
        COUNT.set(0);
    }

    public static LoginCountAnswer getInstance() {
        if (null == loginCount) {
            synchronized (LoginCountAnswer.class) {
                if (null == loginCount) {
                    System.out.println("首次创建.");
                    loginCount = new LoginCountAnswer();
                }
            }
        }
        System.out.println("返回实例.");
        return loginCount;
    }

    public int get() {
        return COUNT.get();
    }

    public void incr(String userId) {
        int currCount = 0;
        lock.lock();
        currCount = COUNT.get() + 1;
        COUNT.set(currCount);
        lock.unlock();
        System.out.println("userId=" + userId + ",访问次数:" + currCount);
    }

    public static void main(String[] args) throws InterruptedException {

        /**
         * 分析:
         * 1.ThreadLocal是线程内变量, ThreadLocal.get()以当前线程this作为key存入
         * 2.单例模型,构造函数只会初始化一次
         * 答案: 第二个Thread会报空指针错位
         * 问题: 两次新开线程, 那么 ThreadLocal 分别是两个不同的对象, 由于单例模型只初始化了一次 ThreadLocal
         * 应该写成: AtomicInteger COUNT = new AtomicInteger(0)
         */
        Thread a = new Thread(() -> LoginCountAnswer.getInstance().incr("a"));

        Thread b = new Thread(() -> LoginCountAnswer.getInstance().incr("b"));

        a.start();
        b.start();
    }

}
