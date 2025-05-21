package designmode.t9_strategy.ordinary;

import designmode.t9_strategy.ordinary.context.StrategyContext;
import designmode.t9_strategy.ordinary.service.impl.AddOperation;
import designmode.t9_strategy.ordinary.service.impl.MultiOperation;
import designmode.t9_strategy.ordinary.service.impl.SubtractOperation;

public class RunText {
    public static void main(String[] args) {
        /*
         * 优点：
         *      1.算法可以自由切换
         *      2.避免使用多重条件判断
         *      3.扩展性良好
         * 缺点：
         *      1.策略类会增多。
         *      2.所有策略类都需要对外暴露
         */
        AddOperation addOperation = new AddOperation();
        SubtractOperation subtractOperation = new SubtractOperation();
        MultiOperation multiOperation = new MultiOperation();

        int x = 10;
        int y = 5;
        StrategyContext strategyContext = new StrategyContext(addOperation);
        strategyContext.doOperator(x, y);
        strategyContext = new StrategyContext(subtractOperation);
        strategyContext.doOperator(x, y);
        strategyContext = new StrategyContext(multiOperation);
        strategyContext.doOperator(x, y);
    }
}
