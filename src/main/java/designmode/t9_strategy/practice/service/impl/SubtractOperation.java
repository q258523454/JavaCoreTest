package designmode.t9_strategy.practice.service.impl;

import designmode.t9_strategy.practice.service.OperationService;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class SubtractOperation implements OperationService {

    @Override
    public void doOperator(int x, int y) {
        log.info("x-y=" + (x - y));
    }
}
