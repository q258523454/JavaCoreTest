package javacore.other;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-08-22
 */

public class Test {
    public void m() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a", "1");
        System.out.println(JSONObject.toJSONString(jsonObject));

    }
    public static void main(String[] args) {
        System.out.println("hello");
        Test test = new Test();
        test.m();
    }
}
