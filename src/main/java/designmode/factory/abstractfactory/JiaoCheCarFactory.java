package designmode.factory.abstractfactory;

import designmode.factory.abstractfactory.entity.AudiJiaoche;
import designmode.factory.abstractfactory.entity.BwmJiaoche;
import designmode.factory.abstractfactory.entity.Car;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-19
 */
public class JiaoCheCarFactory implements CarAbstractFactory {
    @Override
    public Car createBwm() {
        return new BwmJiaoche();
    }

    @Override
    public Car createAudi() {
        return new AudiJiaoche();
    }
}
