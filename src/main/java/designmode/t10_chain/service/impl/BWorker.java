package designmode.t10_chain.service.impl;


import designmode.t10_chain.service.WorkInterceptor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BWorker implements WorkInterceptor {

    @Override
    public void punchIn() {
        log.info("B签到");
    }

    @Override
    public void doWork() {
        log.info("B工作");
    }

    @Override
    public void punchOut() {
        log.info("自定义:B签退");

    }
}
