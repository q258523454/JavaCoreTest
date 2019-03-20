package designmode.abstractfactory;

import designmode.abstractfactory.entity.AudiYueye;
import designmode.abstractfactory.entity.Car;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-19
 */
public class YueYeCarFactory implements CarAbstractFactory {
    @Override
    public Car createBwm() {
        return new AudiYueye();
    }

    @Override
    public Car createAudi() {
        return new AudiYueye();
    }
}
