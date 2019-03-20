package designmode.abstractfactory;

import designmode.abstractfactory.entity.Car;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-19
 */
public interface CarAbstractFactory {
    public Car createBwm();

    public Car createAudi();
}
