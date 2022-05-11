package designmode.t10_chain;

import designmode.t10_chain.service.WorkInterceptor;
import designmode.t10_chain.service.impl.AWorker;
import designmode.t10_chain.service.impl.BWorker;

import java.util.List;

public class ZRunTest {

    public static void main(String[] args) {

        WorkInterceptorChain chain = new WorkInterceptorChain();
        // order 表示责任链上的顺序
        chain.addInterceptor(new AWorker(), 2);
        chain.addInterceptor(new BWorker(), 1);
        List<WorkInterceptor> chainList = chain.getChainList();

        // 记录打卡顺序
        for (WorkInterceptor workInterceptor : chainList) {
            workInterceptor.punchIn();
        }

        // 工作
        for (WorkInterceptor workInterceptor : chainList) {
            workInterceptor.doWork();
        }

        // 签退
        for (WorkInterceptor workInterceptor : chainList) {
            workInterceptor.punchOut();
        }
    }

}
