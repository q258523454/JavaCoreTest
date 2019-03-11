package javacore.multi_thread.multi_thread_volatile;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-05
 */
public class Volatile_2 extends Thread {

    // volatile让变量具有可见性
    private volatile boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    @Override
    public void run() {
        System.out.println("进入run了");
        while (isRunning == true) ;
        System.out.println("线程被停止了！");
    }

    public static void main(String[] args) throws InterruptedException {
        Volatile_2 thread = new Volatile_2();

        thread.start();
        Thread.sleep(1000);
        thread.setRunning(false);

        System.out.println("已经赋值为false");
    }
}