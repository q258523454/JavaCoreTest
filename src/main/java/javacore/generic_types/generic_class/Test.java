package javacore.generic_types.generic_class;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-18
 */
public class Test {
    public static void main(String[] args) {
        MyGeneric<String> myGeneric1 = new MyGeneric<String>("1");
        MyGeneric<Integer> myGeneric2 = new MyGeneric<Integer>(2);
        System.out.println(myGeneric1.getT() + "," + myGeneric2.getT());

        MyGeneric<Number> myGeneric3 = new MyGeneric<Number>(3);
        myGeneric3.test(myGeneric2);
        System.out.println(myGeneric3.getT());

    }
}
