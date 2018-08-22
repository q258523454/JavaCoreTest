package javacore.paraller;
// Created by ZhangJian on 17/12/22.

import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Student> list = new LinkedList<Student>();
        int maxNum = 100000;
        for (int i = 0; i < maxNum; i++) {
            list.add(new Student("student" + i, i));
        }

        //开始测试不同方式的for性能
        int listSize = list.size();
        String searchName = "student666";
        boolean searchFlag = false;

        //基本形式的for循环
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < listSize; i++) {
            Student val = list.get(i);
            if (searchName.equals(val.getName())) {
                searchFlag = true;
            }
        }
        long endTime1 = System.currentTimeMillis();

        //foreach形式
        long startTime2 = System.currentTimeMillis();
        for (Student stu : list) {
            if (searchName.equals(stu.getName())) {
                searchFlag = true;
            }
        }
        long endTime2 = System.currentTimeMillis();

        //输出运行时间
        System.out.println("fori: " + (endTime1 - startTime1));
        System.out.println("forearch: " + (endTime2 - startTime2));

    }
}
