package MultiThread;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-06-12
 */

public class TestThread {

        public static void main(String[] args) {
        Thread one = new Thread() {
            public void run() {
                try {

                    System.out.println("Does it work?");

                    Thread.sleep(2000);

                    System.out.println("Nope, it doesnt...again.");
                } catch(InterruptedException v) {
                    System.out.println(v);
                }
            }
        };

        System.out.println("a");

        one.start();
        System.out.println("a");
        System.out.println("b");

        System.out.println("c");


    }
    public void someFunction(final String data) {
        System.out.println(data);
        new Thread(new Runnable() {
            public void run() {
                System.out.println(data);

            }
        }).start();
    }

}
