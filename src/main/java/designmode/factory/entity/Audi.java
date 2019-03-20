package designmode.factory.entity;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-19
 */
public class Audi implements Car {

    public Audi() {
        System.out.println("奥迪");
    }

    @Override
    public void drive() {
        System.out.println("Drive Audi");
    }
}
