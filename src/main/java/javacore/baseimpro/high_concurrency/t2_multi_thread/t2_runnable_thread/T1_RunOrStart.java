package javacore.baseimpro.high_concurrency.t2_multi_thread.t2_runnable_thread;

/**
 * Created By
 *
 * @date :   2018-09-27
 */
public class T1_RunOrStart {

    public static void main(String args[]) {
        Thread t = new Thread() {
            @Override
            public void run() {
                pong();
            }
        };
        t.start(); // start方法来启动线程，真正实现了多线程运行
//        t.run(); // run()方法只是类的一个普通方法而已，如果直接调用Run方法，程序中依然只有主线程这一个线程，其程序执行路径还是只有一条，还是要顺序执行
        System.out.println("B");
    }

    static void pong() {
        System.out.println("A");
    }


}
