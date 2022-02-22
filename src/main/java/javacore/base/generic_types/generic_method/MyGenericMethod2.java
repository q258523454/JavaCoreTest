package javacore.base.generic_types.generic_method;

import lombok.extern.slf4j.Slf4j;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-18
 */
@Slf4j
public class MyGenericMethod2 {
    private static class Fruit {
        @Override
        public String toString() {
            return "fruit";
        }
    }

    private static class Apple extends Fruit {
        @Override
        public String toString() {
            return "apple";
        }
    }

    private static class Person {
        @Override
        public String toString() {
            return "Person";
        }
    }

    private static class TypeShow<T> {
        public void show_1(T t) {
            log.info(t.toString());
        }

        // 在泛型类中声明了一个泛型方法，使用泛型T，注意这个T是一种全新的类型，可以与泛型类中声明的T不是同一种类型。
        public <T> void show_2(T t) {
            log.info(t.toString());
        }

        /**
         * 在泛型类中声明了一个泛型方法，使用泛型E，这种泛型E可以为任意类型。可以类型与T相同，也可以不同。
         * 由于泛型方法在声明的时候会声明泛型<E>，因此即使在泛型类中并未声明泛型，编译器也能够正确识别泛型方法中识别的泛型。
         * @param t
         * @param <E>
         */
        public <E> void show_3(E t) {
            log.info(t.toString());
        }
    }

    public static void main(String[] args) {
        Apple apple = new Apple();
        Person person = new Person();

        TypeShow<Fruit> typeShow = new TypeShow<>();
        // apple是Fruit的子类，所以这里可以
        typeShow.show_1(apple);
        // 编译器会报错，因为泛型类型实参指定的是Fruit，而传入的实参类是Person
        //typeShow.show_1(person);

        // 使用这两个方法都可以成功 <T>新声明的类型
        typeShow.show_2(apple);
        typeShow.show_2(person);

        // 使用这两个方法也都可以成功 <E>新声明的类型
        typeShow.show_3(apple);
        typeShow.show_3(person);
    }
}
