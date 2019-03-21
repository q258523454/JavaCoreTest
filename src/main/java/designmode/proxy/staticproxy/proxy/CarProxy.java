package designmode.proxy.staticproxy.proxy;

import designmode.proxy.staticproxy.CarInterface;
import designmode.proxy.staticproxy.impl.CarImpl;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-20
 */
public class CarProxy implements CarInterface {

    private CarImpl bwm;

    // 既然是代理, 那就必须获取对象
    public CarProxy(CarImpl bwm) {
        this.bwm = bwm;
    }

    @Override
    public void print() {
        System.out.println("我是汽车代理");
        // 代理也需要实现代理对象的接口方法
        this.bwm.print();
    }
}
