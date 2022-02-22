package javacore.base.t2_collection.set.hashset;

import com.alibaba.fastjson.JSONObject;
import javacore.base.t2_collection.set.hashset.entity.Student;
import javacore.base.t2_collection.set.hashset.entity.Student2;
import javacore.base.t2_collection.set.hashset.entity.StudentOrg;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-04-04
 */
@Slf4j
public class RunTest {
    public static void main(String[] args) {

        /**
         * 	HashSet<>底层实现:
         1.e与HashSet()中元素的 hashCode() 比较, 不同则加入, 相同进入2
         2.e与HashSet()中元素的 equals() 比较, 不同则加入, 相同进入3
         3.不操作
         */
        log.info("----------------- 未重写 hashCode 和 equals -----------------");
        // hashCode()根据属性值规则生成,equals()重写
        StudentOrg stuOrg_1 = new StudentOrg("a", 1);
        StudentOrg stuOrg_2 = new StudentOrg("b", 2);
        StudentOrg stuOrg_3 = new StudentOrg("a", 1);
        // hashCode()由虚拟机随机生成, 一般来说不相等, 不排除相等的情况
        log.info("" + stuOrg_1.hashCode());
        log.info("" + stuOrg_2.hashCode());
        log.info("" + stuOrg_3.hashCode());
        Set<StudentOrg> set = new HashSet<>();
        set.add(stuOrg_1);
        set.add(stuOrg_2);
        set.add(stuOrg_3);

        log.info("遍历所有set:");
        Iterator<StudentOrg> iterator = set.iterator();
        while (iterator.hasNext()) {
            StudentOrg student = iterator.next();
            log.info(JSONObject.toJSONString(student));
        }

        log.info("----------------- 重写 hashCode 和 equals -----------------");
        // hashCode()根据属性值规则生成,equals()重写
        Student stu1 = new Student("a", 1);
        Student stu2 = new Student("b", 2);
        Student stu3 = new Student("a", 1);
        stu1.hashCode();
        stu2.hashCode();
        stu3.hashCode();
        log.info("使用Set.add(),会对元素进行hashCode/equals判断.");
        Set<Student> set1 = new HashSet<>();
        set1.add(stu1);
        set1.add(stu2);
        set1.add(stu3);

        log.info("遍历所有set:（会发现由于hashCode/equals相等,会判断重复元素,不添加）");
        Iterator<Student> iterator1 = set1.iterator();
        while (iterator1.hasNext()) {
            Student student = iterator1.next();
            log.info(JSONObject.toJSONString(student));
        }

        log.info("----------------- 重写 hashCode(随机生成) 和 equals -----------------");
        // hashCode()每次都随机生成
        Student2 stu2_1 = new Student2("a", 1);
        Student2 stu2_2 = new Student2("b", 2);
        Student2 stu2_3 = new Student2("a", 1);
        stu2_1.hashCode();
        stu2_2.hashCode();
        stu2_3.hashCode();

        log.info("使用Set.add(),会对元素进行hashCode/equals判断.");
        HashSet<Student2> set2 = new HashSet<>();
        set2.add(stu2_1); // 这里会调用 student.hashCode()
        set2.add(stu2_2);
        set2.add(stu2_3);

        log.info("遍历所有set:");
        Iterator<Student2> iterator2 = set2.iterator();
        while (iterator2.hasNext()) {
            Student2 student2 = iterator2.next();
            log.info(JSONObject.toJSONString(student2));
        }

    }
}
