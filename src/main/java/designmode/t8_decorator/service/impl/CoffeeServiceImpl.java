package designmode.t8_decorator.service.impl;

import designmode.t8_decorator.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CoffeeServiceImpl implements CoffeeService {

    @Override
    public void drink() {
        log.info("喝咖啡.");
    }

}
