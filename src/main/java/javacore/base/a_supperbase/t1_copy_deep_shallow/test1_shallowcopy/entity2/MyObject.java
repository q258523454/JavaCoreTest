
package javacore.base.a_supperbase.t1_copy_deep_shallow.test1_shallowcopy.entity2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyObject {
    private int id;
    private List<Student> studentList;

}
