package javacore.jdk18.lamdba_useConstruct;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @Date: 2019-07-22
 * @Version 1.0
 */

@Slf4j
public class RunTest {

    public static void main(String[] args) {
        Student stu1 = new Student();
        stu1.setId(1);
        stu1.setName("a");
        stu1.setAge(11);

        Student stu2 = new Student();
        stu2.setId(2);
        stu2.setName("b");
        stu2.setAge(22);

        Student stu3 = new Student();
        stu3.setId(3);
        stu3.setName("c");
        stu3.setAge(33);

        List<Student> studentList = new ArrayList<>();
        studentList.add(stu1);
        studentList.add(stu3);
        studentList.add(stu2);

        List<String> stringList = studentToString(studentList, ArrayList::new);
        log.info(JSON.toJSONString(stringList));
    }


    /**
     * 方法接受一个函数式接口Supplier类型的参数。
     * 在调用这个方法时，将ArrayList的构造函数（ArrayList::new）作为方法引用传给这个参数。
     * 在该方法中调用Supplier类型参数的get方法时，get方法中会通过调用传入的构造函数创建一个ArrayList对象，返回。
     */
    private static List<String> studentToString(List<Student> studentList, Supplier<ArrayList<String>> supplier) {
        List<String> stringList = supplier.get();
        studentList.forEach(student -> stringList.add(student.getName()));
        return stringList;
    }
}
