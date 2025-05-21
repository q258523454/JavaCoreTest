
package designmode.t9_strategy.practice.context;

import designmode.t9_strategy.practice.enums.OperationEnums;
import designmode.t9_strategy.practice.service.OperationService;
import designmode.t9_strategy.practice.service.impl.AddOperation;
import designmode.t9_strategy.practice.service.impl.SubtractOperation;

import java.util.HashMap;
import java.util.Map;

public class OperationMap {

    public static Map<OperationEnums, OperationService> MAP = new HashMap<>();

    static {
        MAP.put(OperationEnums.ADD, new AddOperation());
        MAP.put(OperationEnums.SUBTRACT, new SubtractOperation());
    }
}
