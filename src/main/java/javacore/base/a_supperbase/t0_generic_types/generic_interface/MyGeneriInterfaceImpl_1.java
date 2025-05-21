package javacore.base.a_supperbase.t0_generic_types.generic_interface;

import lombok.extern.slf4j.Slf4j;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-18
 */
@Slf4j
public class MyGeneriInterfaceImpl_1<T> implements MyGeneriInterface<T> {
    private T t;

    public MyGeneriInterfaceImpl_1(T t) {
        this.t = t;
    }

    @Override
    public T print() {
        log.info(t.toString());
        return this.t;
    }

    public static void main(String[] args) {
        MyGeneriInterfaceImpl_1<String> m = new MyGeneriInterfaceImpl_1<>("1");
        m.print();
    }

}
