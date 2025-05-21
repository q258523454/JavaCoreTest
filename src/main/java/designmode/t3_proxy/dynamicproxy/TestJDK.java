package designmode.t3_proxy.dynamicproxy;


import designmode.t3_proxy.dynamicproxy.proxy.JdkDynamicProxy;
import designmode.t3_proxy.dynamicproxy.service.CoffeeService;
import designmode.t3_proxy.dynamicproxy.service.impl.CoffeeServiceImpl;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-20
 */
public class TestJDK {
    public static void main(String[] args) {

        /**
         * JDK动态代理是利用一个实现代理接口的匿名类，在调用具体方法前调用InvokeHandler来处理
         * 缺点——假如又有一个摩托Motor, 该类没有实现任何接口,
         * 那么用Motor motor=(Motor) new DynamicProxy().bind(new Motor()); 编译通过, 但是运行会报错
         */
        CoffeeServiceImpl coffee = new CoffeeServiceImpl();

        /**
         * 基于接口的代理,那就不存在代理 private
         */
        CoffeeService proxy = (CoffeeService) new JdkDynamicProxy().bind(coffee);
        proxy.drink();
    }
}
