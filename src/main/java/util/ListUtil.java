package util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum ListUtil {
    ;

    /**
     * 两个list的不同值
     */
    public static List<String> diff(List<String> listA, List<String> listB) {
        Set<String> setA = new HashSet<>(listA);
        Set<String> setB = new HashSet<>(listB);

        Set<String> difference = new HashSet<>(setA);
        // 并集
        difference.addAll(setB);

        Set<String> intersection = new HashSet<>(setA);
        // 交集
        intersection.retainAll(setB);

        // 并集 - 交集 = 对称差集
        difference.removeAll(intersection);
        return new ArrayList<>(difference);
    }

}
