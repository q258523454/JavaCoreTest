package designmode.t4_template.service;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractWorkTemplate implements WorkTemplateService {

    /**
     * protected  包访问属性: 当前包和子包
     */
    protected abstract void doWork();

    @Override
    public void doBusiness() {
        String currentJob = this.getClass().getSimpleName();
        log.info("工作前:" + currentJob + "签到");
        doWork();
        log.info("工作后:" + currentJob + "签退");
    }
}
