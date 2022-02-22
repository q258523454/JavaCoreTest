package javacore.base.t2_collection.map.hashmap.why_hashcode_equal;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class StudentHashEqual {
    private String name;
    private int age;

    public StudentHashEqual(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StudentHashEqual studentHashEqual = (StudentHashEqual) o;
        return age == studentHashEqual.age &&
                Objects.equals(name, studentHashEqual.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
