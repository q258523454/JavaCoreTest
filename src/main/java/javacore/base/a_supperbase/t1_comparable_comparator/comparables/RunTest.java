package javacore.base.a_supperbase.t1_comparable_comparator.comparables;


import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Builder
@Data
public class RunTest implements Comparable<RunTest> {

    private int id;

    @Override
    public int compareTo(RunTest o) {
        if (id > o.id) {
            return 1;
        } else if (id == o.id) {
            return 0;
        }
        return -1;
    }

    /**
     * comparable  和 comparator 区别:
     * comparable 是内部比较器,例如：预先想定义排序方式或者想使用 Collections.sort()
     * comparator 是外部比较器(记忆'to'), 例如: 对于没有用实现comparable或者想自定义比较器
     *            相比于comparable,它更加灵活.(策略模式)
     */
    public static void main(String[] args) {
        RunTest t1 = RunTest.builder().id(2).build();
        RunTest t2 = RunTest.builder().id(1).build();
        System.out.println(t1.compareTo(t2));

        List<RunTest> list = new ArrayList<>();
        list.add(t1);
        list.add(t2);
        System.out.println(list);
        // collections.sort 必须要实现 Comparable
        Collections.sort(list);
        System.out.println(list);
    }
}
