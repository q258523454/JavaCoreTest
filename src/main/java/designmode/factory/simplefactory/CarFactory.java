package designmode.factory.simplefactory;

import designmode.factory.simplefactory.entity.Audi;
import designmode.factory.simplefactory.entity.Bwm;
import designmode.factory.simplefactory.entity.Car;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-19
 */
public class CarFactory {

    // 简单工厂模式: 一
    public static Car createCar(String carName) {
        if ("Bwm".equals(carName)) {
            return new Bwm();
        } else if ("Audi".equals(carName)) {
            return new Audi();
        } else {
            return null;
        }
    }

    // 简单工厂模式: 二
    public static Car produceAudi() {
        return new Audi();
    }

    public static Car produceBwm() {
        return new Bwm();
    }

}
