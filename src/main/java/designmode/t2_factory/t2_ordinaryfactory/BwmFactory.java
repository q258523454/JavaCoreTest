package designmode.t2_factory.t2_ordinaryfactory;

import designmode.t2_factory.t2_ordinaryfactory.entity.Bwm;
import designmode.t2_factory.t2_ordinaryfactory.entity.Car;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-19
 */
public class BwmFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Bwm();
    }
}
