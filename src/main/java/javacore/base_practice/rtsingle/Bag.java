package javacore.base_practice.rtsingle;

import lombok.Data;

import java.io.Serializable;

@Data
public class Bag implements Serializable {
    private String name;
    private String color;
}