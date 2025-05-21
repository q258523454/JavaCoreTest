package designmode.t3_proxy.staticproxy;

import designmode.t3_proxy.staticproxy.service.BikeInterface;
import designmode.t3_proxy.staticproxy.service.CarInterface;
import designmode.t3_proxy.staticproxy.service.impl.BikeImpl;
import designmode.t3_proxy.staticproxy.service.impl.CarImpl;
import designmode.t3_proxy.staticproxy.service.proxy.BikeProxy;
import designmode.t3_proxy.staticproxy.service.proxy.CarProxy;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-20
 */
public class RunTest {

    /**
     * 静态代理:一个接口,两个实现,一个代理类,一个普通实现
     */
    public static void main(String[] args) {

        /**
         * 区别:
         *  动态代理 和 静态代理 的区别: 静态代理无需自定义 Proxy类
         * 静态代理
         *  缺点——如果需要新增一个单车, 那么我们需要写Bike接口和实现,以及BikeProxy
         */
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
