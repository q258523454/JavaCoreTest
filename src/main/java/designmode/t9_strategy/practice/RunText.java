package designmode.t9_strategy.practice;

import designmode.t9_strategy.practice.context.OperationMap;
import designmode.t9_strategy.practice.context.StrategyContext;
import designmode.t9_strategy.practice.enums.OperationEnums;
import designmode.t9_strategy.practice.service.OperationService;
import designmode.t9_strategy.practice.service.impl.AddOperation;
import designmode.t9_strategy.practice.service.impl.SubtractOperation;

import java.util.Objects;

public class RunText {
    public static void main(String[] args) {
        // 策略模式消除 if-else
        test(5, 10, OperationEnums.ADD);
        testIfElse(5, 10, OperationEnums.ADD);
    }


    /**
     * 策略模式消除 if-else
     */
    public static void test(int x, int y, OperationEnums operationEnums) {
        OperationService operationService = OperationMap.MAP.get(operationEnums);
        StrategyContext strategyContext = new StrategyContext(operationService);
        strategyContext.doOperator(x, y);
    }

    /**
     * if-else
     */
    public static void testIfElse(int x, int y, OperationEnums operationEnums) {
        OperationService operationService = null;
        if (Objects.equals(operationEnums, OperationEnums.ADD)) {
            operationService = new AddOperation();
        } else if (Objects.equals(operationEnums, OperationEnums.SUBTRACT)) {
            operationService = new SubtractOperation();
        }
        StrategyContext strategyContext = new StrategyContext(operationService);
        strategyContext.doOperator(x, y);
    }
}
