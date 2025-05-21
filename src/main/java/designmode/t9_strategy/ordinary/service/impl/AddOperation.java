package designmode.t9_strategy.ordinary.service.impl;

import designmode.t9_strategy.ordinary.service.OperationService;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class AddOperation implements OperationService {

    @Override
    public void doOperator(int x, int y) {
        log.info("x+y=" + (x + y));
    }
}
