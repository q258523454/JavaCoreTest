
package javacore.base.juc.t3_multi_thread.t5_futuretask.t4_completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public enum FutureUtil {
    ;

    public static CompletableFuture<Object> getFuture(String name, long sleep, int nThreads) {
        return CompletableFuture.supplyAsync(new Supplier<Object>() {
            @Override
            public Object get() {
                System.out.println(name + " start");
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + " end");
                return name;
            }
        }, Executors.newFixedThreadPool(nThreads));
    }
}
