package javacore.base.jdk.list;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Student {
    private int id;
    private String name;
}
