package designmode.proxy.dynamicproxy;


import designmode.proxy.dynamicproxy.service.impl.BikeImpl;
import designmode.proxy.dynamicproxy.service.impl.CarImpl;
import designmode.proxy.dynamicproxy.proxy.JdkDynamicProxy;
import designmode.proxy.dynamicproxy.service.BikeInterface;
import designmode.proxy.dynamicproxy.service.CarInterface;

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
         */
        // 动态代理: 缺点——假如又有一个摩托Motor, 该类没有实现任何接口,
        // 那么用Motor motor=(Motor) new DynamicProxy().bind(new Motor()); 编译通过, 但是运行会报错
        BikeImpl fenghuang = new BikeImpl("凤凰");
        CarImpl audi = new CarImpl("奥迪");

        BikeInterface bike = (BikeInterface) new JdkDynamicProxy().bind(fenghuang);
        bike.print();

        CarInterface car = (CarInterface) new JdkDynamicProxy().bind(audi);
        car.print();

    }
}
