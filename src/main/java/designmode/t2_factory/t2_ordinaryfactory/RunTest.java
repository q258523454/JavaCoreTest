package designmode.t2_factory.t2_ordinaryfactory;

import designmode.t2_factory.t2_ordinaryfactory.entity.Car;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-19
 */
public class RunTest {
    public static void main(String[] args) {
        // 这里是普通工厂， 抽象工厂对普通工厂来说, 抽象工厂对工厂再一次进行了抽象
        CarFactory creator = new AudiFactory();
        Car audi = creator.createCar();
        audi.drive();
        creator = new BwmFactory();
        Car bwm = creator.createCar();
        bwm.drive();
    }
}
