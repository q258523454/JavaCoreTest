package designmode.factory.abstractfactory;

import designmode.factory.abstractfactory.entity.Car;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-19
 */
public interface CarAbstractFactory {
    Car createBwm();

    Car createAudi();
}
