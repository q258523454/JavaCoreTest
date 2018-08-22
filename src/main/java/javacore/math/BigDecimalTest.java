package javacore.math;

import java.math.BigDecimal;

/**
 * Created by mac on 17/7/17.
 */
public class BigDecimalTest {

    public static void main(String agrs[]) {


        int K = 5;
        int i = 0;
        int t = 2;
        BigDecimal bigDec = BigDecimal.valueOf(K);


        BigDecimal sum = BigDecimal.valueOf(1);


        for (i = t; i >= 1; i--) {
            sum = sum.multiply(BigDecimal.valueOf(K - i + 1).divide(BigDecimal.valueOf(i)));
        }

        System.out.println(sum);


    }

}
