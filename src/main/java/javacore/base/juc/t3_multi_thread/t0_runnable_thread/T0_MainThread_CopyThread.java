package javacore.base.juc.t3_multi_thread.t0_runnable_thread;

public class T0_MainThread_CopyThread {
    static class MyThread extends Thread {
        private boolean isRunning = true;

        private boolean isRunning() {
            return isRunning;
        }

        public void setRunning(boolean isRunning) {
            this.isRunning = isRunning;
        }

        @Override
        public void run() {
            System.out.println("begin");
            while (isRunning) {

            }
            System.out.println("end");

        }
    }

    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.start();
            Thread.sleep(1000);
            // 输出:begin, 死循环.
            // 原因：主内存赋值 不会刷新 线程的工作区, 除非用 volatile
            myThread.setRunning(false);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
