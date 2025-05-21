package designmode.t9_strategy.ordinary.context;

import designmode.t9_strategy.ordinary.service.OperationService;

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
