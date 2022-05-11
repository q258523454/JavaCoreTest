package designmode.t3_proxy.staticproxy.service.proxy;

import designmode.t3_proxy.staticproxy.service.BikeInterface;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-20
 */
public class BikeProxy implements BikeInterface {


    private BikeInterface bike;

    public BikeProxy(BikeInterface bike) {
        this.bike = bike;
    }

    @Override
    public void print() {
        System.out.println("我的单车代理");
        bike.print();
    }
}
