package javacore.base_practice.rtsingle;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {
    private String name;
    private int age;
    private Bag bag;
}
