package designmode.proxy.dynamicproxy;


import designmode.proxy.dynamicproxy.entity.Student;
import designmode.proxy.dynamicproxy.proxy.CglibDynamicProxy;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Method;

@Slf4j
public class TestCglib {


    public static void main(String[] args) {

        /**
         * cglib动态代理是利用asm开源包，对代理对象类的class文件加载进来，通过修改其字节码生成子类
         * 因为是继承，默认不能代理 private,static,final
         * 虽然private无法代理,但是 method.setAccessible(true) 可以让 private 被执行
         */

        // 创建字节码增强器
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(Student.class);
        // 设置回调函数
        enhancer.setCallback(new CglibDynamicProxy());
        // 创建 Cglib 代理对象, 实例对象和代理对象是两个不同的对象,虽然都是通一个类的对象
        Student student = (Student) enhancer.create();
        // cglib 增强类直接调用
        student.run("test");
        System.out.println("------------------------------");
        // 通过反射调用 private 方法, 报错
        defaultOnlyPublic(student);
        // 通过 setAccessible(true) ,仍然无法代理, 只是执行
        canPrivate(student);
    }

    @SneakyThrows
    public static void defaultOnlyPublic(Student student) {
        // 通过反射调用 private 方法, 报错:private方法不存在
        Method run = Student.class.getDeclaredMethod("run", String.class);
        run.invoke(student, "1");
        try {
            Method cry = Student.class.getDeclaredMethod("cry", String.class);
            cry.invoke(student, "2");
        } catch (Exception ex) {
            log.warn("默认不能代理 private 方法");
        }
    }

    /**
     * 通过 setAccessible(true) 强制执行 private
     * 注意: 仍然无法代理, 只是执行
     */
    @SneakyThrows
    public static void canPrivate(Student student) {
        Method cry = Student.class.getDeclaredMethod("cry", String.class);
        cry.setAccessible(true);
        cry.invoke(student, "3");
    }


}
