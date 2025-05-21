package javacore.base.a_supperbase.t0_generic_types.base;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@ToString
public class MyGeneric_Super_Extends {
    static class Fruit {
        public Fruit() {
        }
    }

    static class Apple extends Fruit {
        public Apple() {
            super();
        }
    }

    static class Orange extends Fruit {
        public Orange() {
            super();
        }
    }

    public static void main(String[] args) {
        /**
         *  List<? extends T>
         *      下界T,全部是T的超类,不可插入,可读取
         *  List<? super T>
         *      上界T,全部是T的子类,可插入T类型,读取可能异常
         */
        List<? extends Fruit> list1 = new ArrayList<>();
        // 编译报错
        // list1.add(new Apple());
        // 编译报错
        // list1.add(new Orange());

        List<? super Apple> list2 = new ArrayList<>();
        // 正常插入
        list2.add(new Apple());
        // 编译报错
        // list2.add(new Orange());
    }
}
