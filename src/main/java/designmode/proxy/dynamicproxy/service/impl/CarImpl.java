package designmode.proxy.dynamicproxy.service.impl;


import designmode.proxy.dynamicproxy.service.CarInterface;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-20
 */
public class CarImpl implements CarInterface {

    private String name;

    public CarImpl(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println("我是汽车:" + name);
    }
}
