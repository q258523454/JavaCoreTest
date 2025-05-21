package designmode.t8_decorator;

import designmode.t8_decorator.service.CoffeeDecorator;
import designmode.t8_decorator.service.impl.CoffeeServiceImpl;

public class ZRunTest {
    public static void main(String[] args) {
        /**
         * 装饰者模式
         * 不改变原有类,extend被扩展的装饰类. 对 Decorator 抽象类进行扩展.
         *
         * 代理模式 VS 装饰者
         *     代理模式: 强调功能
         *     装饰者: 扩展功能, 支持层次嵌套(功能扩展)
         */
        CoffeeServiceImpl workService = new CoffeeServiceImpl();
        CoffeeDecorator decorator = new PersonA(workService);
        decorator.drink();
    }

}
