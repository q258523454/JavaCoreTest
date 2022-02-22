package javacore.base.t1_comparable_comparator.comparators;

import com.alibaba.fastjson.JSON;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@Builder
@Slf4j
@Data
public class RunTest implements Comparator<RunTest> {

    private int id;

    /**
     * {@link Comparator} 降序
     */
    @Override
    public int compare(RunTest o1, RunTest o2) {
        if (o1.id < o2.id) {
            return 1;
        } else if (o1.id == o2.id) {
            return 0;
        }
        return -1;
    }

    /**
     * 自定义比较器
     */
    public static int compareId(RunTest o1, RunTest o2) {
        if (o1.id < o2.id) {
            return 1;
        } else if (o1.id == o2.id) {
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
        List<RunTest> list = new ArrayList<>();
        list.add(RunTest.builder().id(1).build());
        list.add(RunTest.builder().id(3).build());
        list.add(RunTest.builder().id(2).build());

        // 直接使用 Comparator (升序)
        list.sort(new Comparator<RunTest>() {
            @Override
            public int compare(RunTest o1, RunTest o2) {
                if (o1.id > o2.id) {
                    return 1;
                } else if (o1.id == o2.id) {
                    return 0;
                }
                return -1;
            }
        });
        System.out.println(JSON.toJSONString(list));

        // 引用调用 Comparator 比较器 (降序)
        list.sort(RunTest::compareId);
        System.out.println(JSON.toJSONString(list));
    }
}
