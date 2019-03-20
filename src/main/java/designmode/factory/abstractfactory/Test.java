package designmode.factory.abstractfactory;

import designmode.factory.abstractfactory.entity.Car;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-19
 */
public class Test {
    public static void main(String[] args) {
        // 抽象工厂: 就是对普通的工厂来说, 抽象工厂对工厂进行了抽象
        CarAbstractFactory carCreator = new YueYeCarFactory();
        Car audi_yueye = carCreator.createAudi();
        audi_yueye.drive();
        audi_yueye.printCarType();

        carCreator = new JiaoCheCarFactory();
        Car bwm_jiaoche = carCreator.createBwm();
        bwm_jiaoche.drive();
        bwm_jiaoche.printCarType();

    }
}
