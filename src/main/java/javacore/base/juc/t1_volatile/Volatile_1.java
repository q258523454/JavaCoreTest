package javacore.base.juc.t1_volatile;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-05
 */
public class Volatile_1 extends Thread {

    private boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    @Override
    public void run() {
        System.out.println("进入run了");
        while (isRunning) {
            // TODO
        }
        System.out.println("线程被停止了！");
    }

    /**
     * volatile
     * 1.保证可见性
     *   它会保证修改的值会立即被更新到主存，当有其他线程需要读取时，它会去内存中读取新值。
     *   普通共享变量被修改之后，写入主存时间是不确定的，当其他线程去读取时可能还是原来的值，无法保证可见性。
     * 2.有序性(相对有序)
     *   仅保证被 volatile 修饰的变量,在它执行之前,前面的语句一定都执行完了,它后面的语句一定是在它执行完成后执行。
     *   即它只能保证自己的执行相对顺序,没有被 volatile 修饰的语句是无法保证顺序的.
     * 3.不保证原子性
     *
     * volatile 作用:禁止指令重排
     * 例如 单例模式中 Singleton singleton=new Singleton() :
     * 1.实例化对象(分配内存);
     * 2.初始化对象；
     * 3.singleton指向分配的堆内存(singleton!=null)
     * 如果没有  volatile 修饰 singleton,执行顺序会是 1->2->3 或者是 1->3->2
     * 如果是 1->3->2 会出现 singleton!=null 但是使用的时候没有初始化,导致报错.
     */
    public static void main(String[] args) throws InterruptedException {
        Volatile_1 thread = new Volatile_1();

        thread.start();
        Thread.sleep(1000);
        // 主线程修改running, 没有写入主内存, 导致线程没有读到false, 死循环
        thread.setRunning(false);

        System.out.println("已经赋值为false");
    }
}