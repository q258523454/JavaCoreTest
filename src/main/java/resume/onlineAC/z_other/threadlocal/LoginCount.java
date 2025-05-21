package resume.onlineAC.z_other.threadlocal;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 下面代码用来统计某个系统的所有用户登录, 多线程单例模式运行, 会出现什么问题？
 */
public class LoginCount {

    /**
     * 单例
     */
    private static volatile LoginCount loginCount = null;

    /**
     * 技术
     */
    private final ThreadLocal<Integer> count = new ThreadLocal<>();

    /**
     * 单例
     */
    private final Lock lock = new ReentrantLock();

    public LoginCount() {
        System.out.println("set count = 0");
        count.set(0);
    }

    public static LoginCount getInstance() {
        if (null == loginCount) {
            synchronized (LoginCount.class) {
                if (null == loginCount) {
                    System.out.println("首次创建.");
                    loginCount = new LoginCount();
                }
            }
        }
        System.out.println("返回实例.");
        return loginCount;
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

        Thread a = new Thread(() -> LoginCount.getInstance().incr("a"));

        Thread b = new Thread(() -> LoginCount.getInstance().incr("b"));

        a.start();
        b.start();
    }
}
