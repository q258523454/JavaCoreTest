
package practice.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import lombok.SneakyThrows;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;

public class Test {

    /**
     * 序列化单个对象
     * 待序列化内容如下:
     * {
     *   "age": 18,
     *   "bag": {
     *     "color": "black",
     *     "name": "nike"
     *   },
     *   "name": "zhangsan"
     * }
     */
    public static final String JSON_PATH = "E:\\JavaProject\\local\\JavaCoreTest\\src\\main\\resources\\jsonfile\\student.json";

    /**
     * 序列化 对象List
     * 待序列化内容如下:
     * [
     *   {
     *     "name": "zhangsan",
     *     "age": 18,
     *     "bag": {
     *       "color": "black",
     *       "name": "nike"
     *     }
     *   },
     *   {
     *     "name": "lisi",
     *     "age": 25,
     *     "bag": {
     *       "color": "red",
     *       "name": "lining"
     *     }
     *   }
     * ]
     */
    public static final String JSON_LIST_PATH = "E:\\JavaProject\\local\\JavaCoreTest\\src\\main\\resources\\jsonfile\\studentlist.json";

    @SneakyThrows
    public static void main(String[] args) {
        parseSingleObject();
        System.out.println("-------------------");
        parseListObject();
    }


    /**
     * 序列化单个对象
     */
    @SneakyThrows
    public static void parseSingleObject() {
        File file = new File(JSON_PATH);
        String content = FileUtils.readFileToString(file, "UTF-8");
        Student student = JSONObject.parseObject(content, Student.class);
        System.out.println(JSONObject.toJSONString(student));
    }

    /**
     * 序列化对象List
     */
    @SneakyThrows
    public static void parseListObject() {
        File file = new File(JSON_LIST_PATH);
        String content = FileUtils.readFileToString(file, "UTF-8");
        List<Student> studentList = JSON.parseArray(content, Student.class);
        System.out.println(JSONObject.toJSONString(studentList));
    }


    public static void printObject() {
        Bag bag = new Bag();
        bag.setName("nike");
        bag.setColor("black");

        Student student = new Student();
        student.setName("zhangsan");
        student.setAge(18);
        student.setBag(bag);
        System.out.println(JSON.toJSONString(student));
    }
}
