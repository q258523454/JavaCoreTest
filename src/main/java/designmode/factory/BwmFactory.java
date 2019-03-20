package designmode.factory;

import designmode.factory.entity.Bwm;
import designmode.factory.entity.Car;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-19
 */
public class BwmFactory implements CarAbstractFactory {
    @Override
    public Car createCar() {
        return new Bwm();
    }
}
