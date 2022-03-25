package javacore.base.juc.t3_multi_thread.t8_futuretask.t2_executorservice_submit_block;


import lombok.AllArgsConstructor;


@AllArgsConstructor
public class MyRunnable implements Runnable {
    private String command;
    private long timeout;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":开始");
        try {
            Thread.sleep(timeout);
            System.out.println(Thread.currentThread().getName() + ":未中断");
        } catch (Exception e) {
            System.out.println(Thread.currentThread().getName() + ":中断");
        }
        System.out.println(Thread.currentThread().getName() + ":结束");
    }
}
