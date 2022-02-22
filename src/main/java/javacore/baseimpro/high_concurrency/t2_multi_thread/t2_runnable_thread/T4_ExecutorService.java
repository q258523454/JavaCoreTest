package javacore.baseimpro.high_concurrency.t2_multi_thread.t2_runnable_thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @Description
 * @date 2020-06-28 21:16
 * @modify
 */
@Slf4j
public class T4_ExecutorService {

    public static void main(String[] args) {
        /**
         * 线程池不允许使用Executors去创建,而是通过ThreadPoolExecutor的方式,规避资源耗尽的风险。
         * 说明:Executors返回的线程池对象的弊端如下:
         *   1）FixedThreadPool和SingleThreadPool:
         *     允许的请求队列长度为Integer.MAX_VALUE,可能会堆积大量的请求,从而导致OOM。
         *   2）CachedThreadPool:
         *     允许的创建线程数量为Integer.MAX_VALUE,可能会创建大量的线程,从而导致OOM。
         *  @param corePoolSize 常驻核心线程数,一直会保留,除非手动设置允许 {@code allowCoreThreadTimeOut:允许回收}
         *  @param maximumPoolSize 最大线程数(核心线程数+非核心线程数)
         *  @param keepAliveTime 非核心线程数的最大等待时间,当线程空闲时间达到keepAliveTime时,线程会退出并回收,直到线程数量=corePoolSize
         *  @param unit 定义{@code keepAliveTime}单位
         *  @param workQueue 存放任务的队列
         *                   当核心线程处理不过来, 新的任务会加入队列.
         *                   当队列满了之后,如果没有可用核心线程, 则会启动新的线程,且不会超过最大线程数
         *                   当队列满了之后,如果线程数也达到最大值了, 则会开启拒绝策略来拒收新的任务
         * 线程池按以下行为执行任务:
         *  1. 当执行线程数小于核心线程数时,创建线程。
         *  2. 当执行线程数大于等于核心线程数,且任务队列未满时,将任务放入任务队列。
         *  3. 当执行线程数大于等于核心线程数,且任务队列已满
         *     - 若执行线程数小于最大线程数,创建新线程, 空闲后会自动销毁。
         *     - 若执行线程数等于最大线程数,抛出异常,拒绝任务
         *
         *   任务队列主要有4种拒绝策略：
         *   AbortPolicy(默认)：直接丢弃任务，抛出异常
         *   DiscardPolicy：直接丢弃任务，也不抛出异常
         *   CallerRunsPolicy：只用调用者所在的线程来处理任务
         *   DiscardOldestPolicy：丢弃等待队列中最旧的任务，并执行当前任务
         *
         * 如何设置这些参数?
         * 假设: 
         *  - tasks: 每秒的任务数,假设为 500~1000
         *  - tasksAbility: 每秒能处理的任务数(单个线程), 假设为10个
         *  - responsetime: 系统允许容忍的最大响应时间,假设为1000ms(1s)
         * 参考如下:
         *  - corePoolSize = 每 responsetime 需要多少个线程处理？
         *                 = 每秒需要多少个线程处理？ responsetime=1s
         *      corePoolSize = tasks / (responsetime * tasksAbility)
         *                   = tasks / 10 =  (500~1000) / 10
         *                   = 50~100 个线程. corePoolSize设置应该大于50
         *                   = 80 (根据8-2原则,如果80%的每秒任务数小于800,那么corePoolSize设置为80即可)
         *  - queueCapacity =  coreSizePool * tasksAbility * responsetime
         *                  = 800 (意思是队列里的线程可以等待1s,超过了的需要新开线程来执行)
         *  - maxPoolSize = (max(tasks) - queueCapacity)/ tasksAbility + coreSizePool
         *                = (最大任务数-队列容量)/每个线程每秒处理能力 + 核心线程数
         *                = 20+80
         *                = 100
         *  - rejectedExecutionHandler:根据具体情况来决定,任务不重要可丢弃,任务重要则要利用一些缓冲机制来处理
         *                             默认 handler 是 new ThreadPoolExecutor.AbortPolicy()
         *  - keepAliveTime: 默认(60s),StackOverFlow上有人建议宁愿将线程数设置小一点,也要将keepAliveTime设置大一点.
         *
         */


        ExecutorService executor = new ThreadPoolExecutor(5, 200, 2, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(1024),
                new ThreadFactoryImpl("T4_ExecutorService"));

        T3_OnlyRunnable runnable = new T3_OnlyRunnable();
        executor.execute(runnable);
        executor.shutdown();
        log.info("结束");
    }
}
