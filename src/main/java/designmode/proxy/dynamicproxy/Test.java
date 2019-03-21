package designmode.proxy.dynamicproxy;


import designmode.proxy.dynamicproxy.impl.BikeImpl;
import designmode.proxy.dynamicproxy.impl.CarImpl;
import designmode.proxy.dynamicproxy.proxy.DynamicProxy;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-20
 */
public class Test {
    public static void main(String[] args) {

        // 动态代理: 缺点——假如又有一个摩托Motor, 该类没有实现任何接口,
        // 那么用Motor motor=(Motor) new DynamicProxy().bind(new Motor()); 编译通过, 但是运行会报错
        BikeImpl fenghuang = new BikeImpl("凤凰");
        CarImpl audi = new CarImpl("奥迪");

        BikeInterface bike = (BikeInterface) new DynamicProxy().bind(fenghuang);
        bike.print();

        CarInterface car = (CarInterface) new DynamicProxy().bind(audi);
        car.print();

    }
}
