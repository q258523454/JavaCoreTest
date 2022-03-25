package designmode.t2_factory.t3_abstractfactory;


import designmode.t2_factory.t3_abstractfactory.entity.Car;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-19
 */
public class ZRunTest {
    public static void main(String[] args) {

        /**
         * 总结: 区别在于工厂基类和工厂派生类, 对象基类和对象派生类的使用个数.
         * 简单工厂: 只【一个】具体工厂(基于一个基类), 生产【一个】基类的【多个】派生类
         * 普通工厂: 有【多个】具体工厂(基于一个基类), 每个工厂只生产【一个】基类的【一个】派生类
         * 抽象工厂: 有【多个】具体工厂(基于一个基类), 每个工厂生产【多个】基类的【一个】派生类
         */
        CarFactory creator = new JiaoCheCarFactory();
        Car audi = creator.createAudi();
        audi.drive();

        Car bwm = creator.createBwm();
        bwm.drive();
    }
}
