package javacore.base.jvm.t01_jstack;

public class JvmBase3_DeadLock {

    private static final Object o1 = new Object();
    private static final Object o2 = new Object();


    /**
     * 执行下面函数
     * 第一种方法: 本地运行
     * 第二种方法:
     *          1. 将这个java文件拷贝到 linux的javacore/baseimpro/jvm/abase目录下
     *          2. 执行 javac javacore/baseimpro/jvm/abase/JvmBase3_DeadLock.java编译
     *          3. 运行 java javacore.baseimpro.jvm.abase.JvmBase3_DeadLock
     * jps 找到进程的id
     * jstack pid 会出现: Found 1 deadlock.
     */
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new R1());
        Thread t2 = new Thread(new R2());
        t1.start();
        t2.start();
    }

    static class R1 implements Runnable {
        @Override
        public void run() {
            synchronized (o1) {
                System.out.println("获取锁 o1");
                System.out.println("尝试锁 o2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("获取锁 o2");
                }
            }
        }
    }

    static class R2 implements Runnable {
        @Override
        public void run() {
            synchronized (o2) {
                System.out.println("获取锁 o2");
                System.out.println("尝试锁 o1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("获取锁 o1");
                }
            }
        }
    }
}


