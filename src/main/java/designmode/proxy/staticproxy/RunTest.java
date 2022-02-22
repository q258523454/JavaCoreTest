package designmode.proxy.staticproxy;

import designmode.proxy.staticproxy.impl.BikeImpl;
import designmode.proxy.staticproxy.impl.CarImpl;
import designmode.proxy.staticproxy.proxy.BikeProxy;
import designmode.proxy.staticproxy.proxy.CarProxy;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-20
 */
public class RunTest {

    public static void main(String[] args) {

        // 静态代理: 缺点——如果需要新增一个单车, 那么我们需要写Bike接口和实现,以及BikeProxy
        CarInterface audi = new CarImpl("奥迪");
        CarInterface bwm = new CarImpl("宝马");

        CarProxy carProxy1 = new CarProxy(audi);
        carProxy1.print();

        CarProxy carProxy2 = new CarProxy(bwm);
        carProxy2.print();

        BikeInterface fengkuang = new BikeImpl("凤凰");
        BikeInterface yongjiu = new BikeImpl("永久");

        BikeProxy bikeProxy1 = new BikeProxy(fengkuang);
        bikeProxy1.print();

        BikeProxy bikeProxy2 = new BikeProxy(yongjiu);
        bikeProxy2.print();

    }
}
