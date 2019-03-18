package javacore.generic_types.generic_interface;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-18
 */
public class MyGeneriInterfaceImpl_1<T> implements MyGeneriInterface<T> {
    private T t;

    public MyGeneriInterfaceImpl_1(T t) {
        this.t = t;
    }

    @Override
    public T print() {
        System.out.println(t);
        return this.t;
    }

    public static void main(String[] args) {
        MyGeneriInterfaceImpl_1<String> m = new MyGeneriInterfaceImpl_1<String>("1");
        m.print();
    }

}
