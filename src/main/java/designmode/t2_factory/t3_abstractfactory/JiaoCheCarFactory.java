package designmode.t2_factory.t3_abstractfactory;

import designmode.t2_factory.t3_abstractfactory.entity.AudiJiaoche;
import designmode.t2_factory.t3_abstractfactory.entity.BwmJiaoche;
import designmode.t2_factory.t3_abstractfactory.entity.Car;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-19
 */
public class JiaoCheCarFactory implements CarFactory {
    @Override
    public Car createBwm() {
        return new BwmJiaoche();
    }

    @Override
    public Car createAudi() {
        return new AudiJiaoche();
    }
}
