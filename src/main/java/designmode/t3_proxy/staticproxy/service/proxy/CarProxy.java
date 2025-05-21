package designmode.t3_proxy.staticproxy.service.proxy;

import designmode.t3_proxy.staticproxy.service.CarInterface;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-20
 */
public class CarProxy implements CarInterface {

    private CarInterface bwm;

    // 既然是代理, 那就必须获取对象
    public CarProxy(CarInterface bwm) {
        this.bwm = bwm;
    }

    @Override
    public void print() {
        System.out.println("我是汽车代理");
        // 代理也需要实现代理对象的接口方法
        this.bwm.print();
    }
}
