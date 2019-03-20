package designmode.factory.ordinaryfactory;

import designmode.factory.ordinaryfactory.entity.Audi;
import designmode.factory.ordinaryfactory.entity.Car;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-19
 */
public class AudiFactory implements CarAbstractFactory {
    @Override
    public Car createCar() {
        return new Audi();
    }
}
