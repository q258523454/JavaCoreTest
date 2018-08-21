package packgePair;

import java.time.LocalDate;

/**
 * Created by mac on 17/7/24.
 */
public class FanXing {
    public static void main(String[] args) {
        LocalDate[] birthdays = {
                LocalDate.of(1991, 1, 1),
                LocalDate.of(1992, 2, 2),
                LocalDate.of(1993, 3, 3),
        };
        Pair<LocalDate> mm = ArrayAlg.min(birthdays);
        System.out.println("min=" + mm.getFirst());

//        String[] words = {"A", "b", "a", "C", "f"};
//        Pair<String> aa = ArrayAlg.minMax(words);
//        System.out.println(aa.getFirst());
//        System.out.println(aa.getSecond());

    }
}


class ArrayAlg {
    public static<T extends Comparable> Pair<T> min(T[] a) {
        if (a == null || a.length == 0)
            return null;
        T min = a[0];
        T max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<T>(min, max);
    }
}


