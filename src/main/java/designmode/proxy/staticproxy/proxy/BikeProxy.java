package designmode.proxy.staticproxy.proxy;

import designmode.proxy.staticproxy.BikeInterface;
import designmode.proxy.staticproxy.impl.BikeImpl;

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
