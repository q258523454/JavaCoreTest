package javacore.multi_thread.multi_thread_volatile;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-05
 */
public class Volatile_3 extends Thread {

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
        while (isRunning == true){
            // 注意这里没有volatile, 但是程序没有死循环, 原因是: 输出语句或者sleep方法会让JVM在空闲时将变量隐式的加上volatile
            System.out.println(currentThread().getName()+" is running.");
        }
        System.out.println("线程被停止了！");
    }

    public static void main(String[] args) throws InterruptedException {
        Volatile_3 thread = new Volatile_3();

        thread.start();
        Thread.sleep(1000);
        thread.setRunning(false);

        System.out.println("已经赋值为false");
    }
}