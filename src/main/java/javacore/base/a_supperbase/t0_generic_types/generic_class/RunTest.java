package javacore.base.a_supperbase.t0_generic_types.generic_class;

import lombok.extern.slf4j.Slf4j;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-18
 */
@Slf4j
public class RunTest {
    public static void main(String[] args) {
        MyGeneric<String> myGeneric1 = new MyGeneric<>("1");
        MyGeneric<Integer> myGeneric2 = new MyGeneric<>(2);
        log.info(myGeneric1.getT() + "," + myGeneric2.getT());

        MyGeneric<Number> myGeneric3 = new MyGeneric<>(3);
        myGeneric3.test(myGeneric2);
        log.info("" + myGeneric3.getT());

    }
}
