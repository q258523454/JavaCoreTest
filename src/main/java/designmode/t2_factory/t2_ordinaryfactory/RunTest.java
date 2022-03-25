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

        CarFactory creator = new AudiFactory();
        Car audi = creator.createCar();
        audi.drive();

        creator = new BwmFactory();
        Car bwm = creator.createCar();
        bwm.drive();
    }
}
