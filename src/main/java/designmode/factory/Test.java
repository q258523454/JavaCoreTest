package designmode.factory;

import designmode.factory.entity.Car;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-19
 */
public class Test {
    public static void main(String[] args) {
        // 抽象工厂: 就是对普通的工厂来说, 抽象工厂对工厂进行了抽象
        CarAbstractFactory creator = new AudiFactory();
        Car audi = creator.createCar();
        audi.drive();
        creator = new BwmFactory();
        Car bwm = creator.createCar();
        bwm.drive();
    }
}
