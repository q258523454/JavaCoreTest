package designmode.factory.simplefactory;

import designmode.factory.simplefactory.entity.Car;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-19
 */
public class Test {
    public static void main(String[] args) {

        // 简单工厂模式: 一 (缺点是每次新增一个车型, 都需要新增判断语句, 适合类型比较少的场景)
        Car car = CarFactory.createCar("Audi");
        car.drive();
        car = CarFactory.createCar("Bwm");
        car.drive();

        // 简单工厂模式: 二
        CarFactory carFactory = new CarFactory();
        Car audi = carFactory.produceAudi();
        audi.drive();
        Car bwm = carFactory.produceBwm();
        bwm.drive();

    }
}
