package javacore.base.t2_collection.queue.blocking_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
    /**
     *
     * ------------------------------------------------------------------------
     *       会抛异常       返回特殊值      阻塞      超时
     * 插入   add(o)        offer(o)     put(o)    offer(o, timeout, timeunit)
     * 删除   remove(o)     poll()       take()    poll(o, timeout, timeunit)
     * 检查   element()     peek()
     *------------------------------------------------------------------------
     *
     * 插入:
     *      add(): 如果插入成功则返回 true,否则抛出 IllegalStateException 异常
     *      offer(): 如果插入成功则返回 true,否则返回 false
     *      put(): 插入队列,如果队列满了,则阻塞直到有空间插入
     *      offer(o,timeout,timeunit): 普通offer()方法上加个超时时间
     * 删除:
     *      remove(): 删除第一个元素,没有元素,则返回 false
     *      poll(o): 获取第一个元素并删除, 没有元素, 则返回 null
     *      take(): 获取第一个元素并删除,如果队列为空,则阻塞并等待元素变为可用
     *      poll(o,timeout,timeunit): 检索并删除队列的头部,如有必要,等待指定的等待时间以使元素可用,如果超时,则返回 null
     * 查看:
     *      peek(): 查看第一个元素(不删除),空则返回 null.
     *      element(): 查看第一个元素(不删除),空则抛出异常 NoSuchElementException.
     */
    public static void main(String[] args) throws Exception {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(1024);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();

        Thread.sleep(4000);
        System.exit(0);
    }
}
