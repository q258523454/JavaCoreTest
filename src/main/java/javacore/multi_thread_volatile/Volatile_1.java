package javacore.multi_thread_volatile;

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
        while (isRunning == true) {
            // TODO
        }
        System.out.println("线程被停止了！");
    }

    public static void main(String[] args) throws InterruptedException {
        Volatile_1 thread = new Volatile_1();

        thread.start();
        Thread.sleep(1000);
        thread.setRunning(false);   // 主线程修改running, 没有写入主内存, 导致线程没有读到false, 死循环

        System.out.println("已经赋值为false");
    }
}