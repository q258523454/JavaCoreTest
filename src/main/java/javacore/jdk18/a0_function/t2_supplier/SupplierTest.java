

package javacore.jdk18.a0_function.t2_supplier;

import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SupplierTest {

    public static void main(String[] args) {
        // 供给器
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return new Random().nextInt();
            }
        };

        System.out.println(supplier.get());
    }
}
