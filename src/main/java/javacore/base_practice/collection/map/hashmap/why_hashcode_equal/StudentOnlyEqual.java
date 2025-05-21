package javacore.base_practice.collection.map.hashmap.why_hashcode_equal;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class StudentOnlyEqual {
    private String name;
    private int age;

    public StudentOnlyEqual(String name, int age) {
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
        StudentOnlyEqual studentHashEqual = (StudentOnlyEqual) o;
        return age == studentHashEqual.age &&
                Objects.equals(name, studentHashEqual.name);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
