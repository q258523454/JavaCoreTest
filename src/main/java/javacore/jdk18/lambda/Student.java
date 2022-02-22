package javacore.jdk18.lambda;

/**
 * @Date: 2019-07-22
 * @Version 1.0
 */
public class Student implements Comparable {
    private int id;
    private String name;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 按年龄升序排列
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        if (null == o || !(o.getClass() == Student.class)) {
            return 0;
        }
        Student obj = (Student) o;
        if (this.getAge() > obj.getAge()) {
            return 1;
        } else if (this.getAge() == obj.getAge()) {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * lambda按年龄降序排列
     */
    public static int compareByAge(Object o1, Object o2) {
        if (null == o1 || null == o2 || o1.getClass() != o2.getClass() || !(o1.getClass() == Student.class)) {
            return 0;
        }
        Student obj1 = (Student) o1;
        Student obj2 = (Student) o2;
        if (obj1.getAge() > obj2.getAge()) {
            return -1;
        } else if (obj1.getAge() == obj2.getAge()) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * 名字升序
     * @param o1
     * @param o2
     * @return
     */
    public int compareByName(Object o1, Object o2) {
        if (null == o1 || null == o2 || o1.getClass() != o2.getClass() || !(o1.getClass() == Student.class)) {
            return 0;
        }
        return ((Student) o1).getName().compareTo(((Student) o2).getName());
    }
}
