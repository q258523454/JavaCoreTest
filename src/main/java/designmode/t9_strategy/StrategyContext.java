package designmode.t9_strategy;

import designmode.t9_strategy.service.OperationService;

public class StrategyContext {

    /**
     * Java核心之一：面向接口编程
     */
    private OperationService operationService;

    public StrategyContext(OperationService operationService) {
        this.operationService = operationService;
    }

    public void doOperator(int x, int y) {
        operationService.doOperator(x, y);
    }
}
