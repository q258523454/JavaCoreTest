package designmode.t3_proxy.dynamicproxy;


import designmode.t3_proxy.dynamicproxy.proxy.CglibDynamicProxy;
import designmode.t3_proxy.dynamicproxy.service.impl.CoffeeServiceImpl;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Method;

@Slf4j
public class TestCglib {


    public static void main(String[] args) {

        /**
         * 总结:
         * 代理目的: 增强现有代码功能
         *
         * 动态代理:
         * JDK:
         *  概括: 面向接口（实现类）
         *  原理: 实现回调接口(InvocationHandler)+反射机制
         *  缺点: 必须实现接口方法.
         *
         * CGLIB:
         *  概括: 基于继承(也可以强制让实现接口的类走代理)
         *  原理: 利用ASM开源包,对代理对象类的class文件加载进来,通过修改其字节码生成子类
         *  缺点: 因为是继承，默认不能代理 final 修饰的方法.
         *  注意: 虽然private方法无法通过继承类直接调用,但是 method.setAccessible(true) 可以让 private 方法被执行
         *       extend 是可以继承私有方法和属性的, 只是无法直接调用, 私有属性可以通过get.set方法, 私有方法只能通过 setAccessible
         *       经过测试:
         *       private,static 都无法被代理, 但private可以强制执行.
         */

        // 创建字节码增强器
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(CoffeeServiceImpl.class);
        // 设置回调函数
        enhancer.setCallback(new CglibDynamicProxy());
        // 创建 Cglib 代理对象, 实例对象和代理对象是两个不同的对象,虽然都是通一个类的对象
        CoffeeServiceImpl coffee = (CoffeeServiceImpl) enhancer.create();
        // cglib 增强类直接调用public方法
        coffee.drink();
        System.out.println("------------------------------");
        // 通过反射调用 private 方法, 报错
        // 原因: extend 虽然可以继承私有属性, 但是是不能直接通过继承类执行私有方法的, 可以通过 setAccessible(true)实现.
        defaultOnlyPublic(coffee);
        // 通过 setAccessible(true) ,仍然无法代理, 只是执行
        canPrivate(coffee);
    }

    @SneakyThrows
    public static void defaultOnlyPublic(CoffeeServiceImpl coffee) {
        // 通过反射调用 private 方法, 报错:private方法不存在
        Method run = CoffeeServiceImpl.class.getDeclaredMethod("drink");
        run.invoke(coffee);
        try {
            Method privateMethod = CoffeeServiceImpl.class.getDeclaredMethod("privateMethod", String.class);
            privateMethod.invoke(coffee, "ztest");
        } catch (Exception ex) {
            log.warn("默认不能代理 private 方法");
        }
    }

    /**
     * 通过 setAccessible(true) 强制执行 private
     * 注意:只是执行
     */
    @SneakyThrows
    public static void canPrivate(CoffeeServiceImpl coffee) {
        Method privateMethod = CoffeeServiceImpl.class.getDeclaredMethod("privateMethod", String.class);
        privateMethod.setAccessible(true);
        privateMethod.invoke(coffee, "ztest");
    }
}
