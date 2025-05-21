package designmode.t2_factory.t3_abstractfactory;

import designmode.t2_factory.t3_abstractfactory.entity.AudiYueye;
import designmode.t2_factory.t3_abstractfactory.entity.BwmYueye;
import designmode.t2_factory.t3_abstractfactory.entity.Car;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-19
 */
public class YueYeCarFactory implements CarFactory {
    @Override
    public Car createBwm() {
        return new BwmYueye();
    }

    @Override
    public Car createAudi() {
        return new AudiYueye();
    }
}
