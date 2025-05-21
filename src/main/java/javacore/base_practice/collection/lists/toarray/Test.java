package javacore.base_practice.collection.lists.toarray;

import com.alibaba.fastjson.JSON;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@ToString
public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>() {{
            add("1");
            add("2");
            add("3");
        }};
        /*
         * toArray(T[] a) 的参数应采用零长度的数组，这样可保证有更好的性能
         * 不要写成 Object[] objects = list.toArray();
         */
        String[] objects = list.toArray(new String[0]);
        System.out.println(JSON.toJSONString(objects));
        objects[2] = "10";
        System.out.println(JSON.toJSONString(objects));
    }
}
