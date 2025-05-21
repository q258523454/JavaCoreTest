package designmode.t10_chain;

import designmode.t10_chain.service.WorkInterceptor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class WorkInterceptorChain {

    /**
     * 执行的
     */
    private List<WorkInterceptor> chainList;

    private final Map<Integer, WorkInterceptor> chainMap = new HashMap<>();

    private ReentrantLock lock = new ReentrantLock();

    /**
     * 添加 WorkInterceptor
     * @param interceptor WorkInterceptor
     * @param order 优先级,越小越高.
     */
    public void addInterceptor(WorkInterceptor interceptor, int order) {
        if (chainMap.containsKey(order)) {
            throw new RuntimeException("WorkInterceptor 责任链已存在 order=" + order);
        }
        chainMap.put(order, interceptor);
    }

    /**
     * 返回 chainList
     */
    public List<WorkInterceptor> getChainList() {
        sort();
        return chainList;
    }

    /**
     * 按 order 先后顺序
     */
    public void sort() {
        lock.lock();
        try {
            chainList = chainMap.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey())
                    .map(Map.Entry::getValue)
                    .collect(Collectors.toList());
        } finally {
            lock.unlock();
        }
    }
}
