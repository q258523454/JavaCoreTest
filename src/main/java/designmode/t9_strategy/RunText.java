package designmode.t9_strategy;

import designmode.t9_strategy.service.impl.AddOperation;
import designmode.t9_strategy.service.impl.DeleteOperation;
import designmode.t9_strategy.service.impl.MultiOperation;

public class RunText {
    public static void main(String[] args) {
        /**
         * 优点：
         *      1.算法可以自由切换
         *      2.避免使用多重条件判断
         *      3.扩展性良好
         * 缺点：
         *      1.策略类会增多。
         *      2.所有策略类都需要对外暴露
         */
        AddOperation addOperation = new AddOperation();
        DeleteOperation deleteOperation = new DeleteOperation();
        MultiOperation multiOperation = new MultiOperation();

        int x = 10;
        int y = 5;
        StrategyContext strategyContext = new StrategyContext(addOperation);
        strategyContext.doOperator(x, y);
        strategyContext = new StrategyContext(deleteOperation);
        strategyContext.doOperator(x, y);
        strategyContext = new StrategyContext(multiOperation);
        strategyContext.doOperator(x, y);
    }

}
