package designmode.t4_template;


import designmode.t4_template.service.AbstractWorkTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonA extends AbstractWorkTemplate {

    @Override
    public void doWork() {
        log.info(this.getClass().getSimpleName() + " 干活");
    }
}
