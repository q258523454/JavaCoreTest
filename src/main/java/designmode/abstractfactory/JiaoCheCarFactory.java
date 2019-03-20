package designmode.abstractfactory;

import designmode.abstractfactory.entity.AudiJiaoche;
import designmode.abstractfactory.entity.AudiYueye;
import designmode.abstractfactory.entity.BwmJiaoche;
import designmode.abstractfactory.entity.Car;

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
