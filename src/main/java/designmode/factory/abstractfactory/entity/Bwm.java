package designmode.factory.abstractfactory.entity;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-19
 */
public abstract class Bwm extends Car {

    public Bwm() {
        System.out.println("宝马");
    }

    @Override
    public void drive() {
        System.out.println("Drive Bwm");
    }
}
