package javacore.base.a_supperbase.t1_copy_deep_shallow.test1_shallowcopy.entity2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Student {
    private int id;

    private String name;

    private Bag bag;
}
