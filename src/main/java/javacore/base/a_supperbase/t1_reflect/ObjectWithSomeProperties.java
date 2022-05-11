package javacore.base.a_supperbase.t1_reflect;


import javacore.base.a_supperbase.t1_reflect.newinstance.Student;

import java.lang.reflect.Field;

public class ObjectWithSomeProperties {


    public static void main(String[] args) {
        Student student = new Student(1, "1", 2);
        readAttributeValue(student);

    }

    /**
     * 访问每一个属性
     */
    public static void readAttributeValue(Student obj) {
        String nameVlues = "";
        //Get class
        Class cls = obj.getClass();
        //Get all attributes
        Field[] fields = cls.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {//Traverse
            try {
                //Get attributes
                Field field = fields[i];
                //Turn on private access
                field.setAccessible(true);
                //Get attributes name
                String name = field.getName();
                //Get attribute value
                Object value = field.get(obj);
                //Assign one by one
                nameVlues += field.getName() + ":" + value + ",";
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            String result = nameVlues.substring(0);
            System.out.println(result);
        }
    }
}