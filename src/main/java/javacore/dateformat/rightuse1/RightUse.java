package javacore.dateformat.rightuse1;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-22
 */
public class RightUse {
    public static class InnerStaticSimpleDateFormat implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName() + ":" + DateUtil.parseToDate("2017-07-27 08:02:20"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
            new Thread(new InnerStaticSimpleDateFormat(), "测试线程").start();
        }

    }
}

