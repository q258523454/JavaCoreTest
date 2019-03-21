package designmode.proxy.dynamicproxy.impl;


import designmode.proxy.dynamicproxy.BikeInterface;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-20
 */
public class BikeImpl implements BikeInterface {
    private String name;

    public BikeImpl(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println("我的单车:" + name);
    }
}
