package javacore.base.a_supperbase.t1_reflect;


import com.alibaba.fastjson.JSON;
import javacore.base.a_supperbase.t1_reflect.newinstance.Student;
import lombok.extern.slf4j.Slf4j;
import util.BeanToMapUtil;

@Slf4j
public class BeanMapTest {


    public static void main(String[] args) throws Exception {
        Student student = new Student(1, "2", 3);
        System.out.println(JSON.toJSONString(BeanToMapUtil.beanToMap(student)));
        BeanToMapUtil.readAttributeValue(student);
    }

}