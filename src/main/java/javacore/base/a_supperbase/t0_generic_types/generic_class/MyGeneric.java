package javacore.base.a_supperbase.t0_generic_types.generic_class;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-18
 */
public class MyGeneric<T> {

    private T t;

    public MyGeneric() {
    }

    public MyGeneric(T t) {
        this.t = t;
    }

    public T getT() {
        return this.t;
    }

    // 此处’？’是类型实参，而不是类型形参, 和Number、String、Integer一样都是一种实际的类型，可以把？看成所有类型的父类。是一种真实的类型。
    public void test(MyGeneric<?> obj) {
        System.out.println(obj.getT());
    }

}
