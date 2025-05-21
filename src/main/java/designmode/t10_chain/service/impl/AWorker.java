package designmode.t10_chain.service.impl;


import designmode.t10_chain.service.WorkInterceptor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AWorker implements WorkInterceptor {

    @Override
    public void punchIn() {
        log.info("A签到");
    }

    @Override
    public void doWork() {
        log.info("A工作");
    }
}
