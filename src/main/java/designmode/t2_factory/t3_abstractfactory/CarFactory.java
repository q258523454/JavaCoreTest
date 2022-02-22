package designmode.t2_factory.t3_abstractfactory;

import designmode.t2_factory.t3_abstractfactory.entity.Car;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-19
 */
public interface CarFactory {
    Car createBwm();

    Car createAudi();
}
