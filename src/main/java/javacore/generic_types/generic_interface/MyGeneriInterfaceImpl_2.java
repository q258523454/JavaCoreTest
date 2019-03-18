package javacore.generic_types.generic_interface;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-18
 */
public class MyGeneriInterfaceImpl_2 implements MyGeneriInterface<Integer> {
    private Integer a;

    public MyGeneriInterfaceImpl_2(Integer a) {
        this.a = a;
    }

    @Override
    public Integer print() {
        System.out.println(a);
        return a;
    }

    public static void main(String[] args) {
        MyGeneriInterfaceImpl_2 myGeneriInterfaceImpl_2 = new MyGeneriInterfaceImpl_2(2);
        myGeneriInterfaceImpl_2.print();
    }
}
