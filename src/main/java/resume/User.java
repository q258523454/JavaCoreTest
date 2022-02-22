package resume;

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
public class User {

    public static User user = null;
    private ThreadLocal<Integer> count = new ThreadLocal<>();
    private Lock lock = new ReentrantLock();

    public User() {
        System.out.println("set count = 0");
        count.set(0);
    }

    public static User getInstance() {
        if (null == user) {
            synchronized (User.class) {
                if (null == user) {
                    System.out.println("首次创建.");
                    user = new User();
                }
            }
        }
        System.out.println("返回实例.");
        return user;
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
                User.getInstance().incr("a");
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                User.getInstance().incr("b");
            }
        });

        a.start();
        b.start();
    }

}
