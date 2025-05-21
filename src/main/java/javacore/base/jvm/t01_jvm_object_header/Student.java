package javacore.base.jvm.t01_jvm_object_header;

import lombok.Data;

@Data
public class Student {
    private boolean flag;
    private int id;
    private String name;
    private Object object = new Object();
}
