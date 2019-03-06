package javacore.multi_thread_threadpool_futuretask.synchronized_multiList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by
 *
 * @author :   zj
 * @date :   2018-08-21
 */

public class MultiThreadList {

    /**
     * 多线程处理
     *
     * @param data      数据
     * @param threadNum 线程数
     */
    public synchronized void handleList(List<String> data, int threadNum) {
        int length = data.size();
        int block = length % threadNum == 0 ? length / threadNum : (length / threadNum + 1); // 总共被线程划分成block段
        for (int i = 0; i < threadNum; i++) {
            int end = (i + 1) * block;
            Thread thread1 = new Thread(new MyRunnale(new Apple(), "线程[" + (i + 1) + "] ", data, i * block, end > length ? length : end));
            Thread thread2 = new Thread(new MyRunnale(new Banana(), "线程[" + (i + 1) + "] ", data, i * block, end > length ? length : end));
            thread1.start();
            thread2.start();
        }
    }

    private class MyRunnale implements Runnable {
        // 线程变量定义
        private Fruit fruit;
        private String threadName;
        private List<String> data;
        private int start;
        private int end;

        // 线程构造方法
        public MyRunnale(Fruit fruit, String threadName, List<String> data, int start, int end) {
            this.fruit = fruit;
            this.threadName = threadName;
            this.data = data;
            this.start = start;
            this.end = end;
        }

        // 重写run()方法-线程执行方法
        @Override
        public void run() {
            List<String> subList = data.subList(start, end);
            fruit.func(threadName, subList);
        }
    }

    public static void main(String[] args) {
        MultiThreadList multiThreadTest = new MultiThreadList();
        // 准备数据
        List<String> data = new ArrayList<String>();
        for (int i = 1; i <= 3; i++) {
            data.add("item" + i);
        }
        multiThreadTest.handleList(data, 2);
    }
}
