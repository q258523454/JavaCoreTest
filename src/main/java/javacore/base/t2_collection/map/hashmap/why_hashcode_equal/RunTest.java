package javacore.base.t2_collection.map.hashmap.why_hashcode_equal;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

public class RunTest {
    public static void main(String[] args) {

        /**
         *  重写equal为什么一定也要同时重写hashcode?
         *  例如在 HashMap 中，只有当两个对象hashCode()相等，且equals()相同，才判定为重复元素
         *  假如规定两个 Student 对象只要 id 相同就认为是相等的，我们重写的equals(),实现id相同则返回true.
         *  但是没有重写hashCode(),此时如果我们执行两次 hashMap.put(new Student(id=1)),会发现 hashMap有两个id=1的学生
         *  原因: hashMap先判断hashCode(),由于没有重写,hashcode码为默认的内存地址.导致两个id=1的学生对象的hashCode不一样,就会直接插入.
         *  所以重写对象的equals()方法一定要同时重写hashCode()以符合原则, 否则会出现key重复对象
         */
        StudentHashEqual studentHashEqual1 = new StudentHashEqual("zhang", 13);
        StudentHashEqual studentHashEqual2 = new StudentHashEqual("zhang", 13);
        HashMap<StudentHashEqual, String> hashMap = new HashMap<>();
        hashMap.put(studentHashEqual1, "1");
        hashMap.put(studentHashEqual2, "2");
        System.out.println("studentOnlyEqual1 hashCode:" + studentHashEqual1.hashCode());
        System.out.println("studentOnlyEqual2 hashCode:" + studentHashEqual2.hashCode());
        System.out.println(JSON.toJSONString(hashMap));

        StudentOnlyEqual studentOnlyEqual1 = new StudentOnlyEqual("zhang", 13);
        StudentOnlyEqual studentOnlyEqual2 = new StudentOnlyEqual("zhang", 13);
        HashMap<StudentOnlyEqual, String> hashMap3 = new HashMap<>();
        hashMap3.put(studentOnlyEqual1, "1");
        hashMap3.put(studentOnlyEqual2, "2");
        System.out.println("studentOnlyEqual1 hashCode:" + studentOnlyEqual1.hashCode());
        System.out.println("studentOnlyEqual2 hashCode:" + studentOnlyEqual2.hashCode());
        System.out.println(JSON.toJSONString(hashMap3));
    }
}
