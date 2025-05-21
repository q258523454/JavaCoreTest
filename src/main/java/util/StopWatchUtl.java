
package util;

import org.springframework.util.StopWatch;

public enum StopWatchUtl {
    ;

    public static void main(String[] args) throws InterruptedException {
        test1();
        test2();
    }


    /**
     * 统计输出总耗时
     */
    public static void test1() throws InterruptedException {
        StopWatch sw = new StopWatch();
        sw.start();
        Thread.sleep(100);
        sw.stop();
        // 毫秒
        System.out.println(sw.getTotalTimeMillis());
        // 秒
        System.out.println(sw.getTotalTimeSeconds());
    }

    /**
     * 输出最后一个任务的耗时
     */
    public static void test2() throws InterruptedException {
        StopWatch sw = new StopWatch();
        sw.start("A");
        Thread.sleep(100);
        sw.stop();
        sw.start("B");
        Thread.sleep(500);
        sw.stop();
        // 输出最后一个任务的耗时
        System.out.println(sw.getLastTaskTimeMillis());
    }


    /**
     * 优雅的格式打出所有任务的耗时以及占比
     */
    public static void test() throws InterruptedException {
        StopWatch sw = new StopWatch();
        sw.start("A");
        Thread.sleep(500);
        sw.stop();
        sw.start("B");
        Thread.sleep(300);
        sw.stop();
        sw.start("C");
        Thread.sleep(200);
        sw.stop();
        System.out.println(sw.prettyPrint());
    }
}
