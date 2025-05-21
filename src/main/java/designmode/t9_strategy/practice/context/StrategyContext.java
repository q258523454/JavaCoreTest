package designmode.t9_strategy.practice.context;

import designmode.t9_strategy.practice.service.OperationService;

public class StrategyContext {

    /**
     * Java核心之一：面向接口编程
     */
    private final OperationService operationService;

    public StrategyContext(OperationService operationService) {
        this.operationService = operationService;
    }

    public void doOperator(int x, int y) {
        operationService.doOperator(x, y);
    }
}
