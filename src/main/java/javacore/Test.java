package javacore;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By
 *
 * @author :   zhangjian
 * @date :   2018-09-06
 */
public class Test {
    private final static Logger log = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        List<String> arrayList = new ArrayList();
        arrayList.add("aaaa");

        for (int i = 0; i < arrayList.size(); i++) {
            String item = (String) arrayList.get(i);
            log.info("泛型测试", "item = " + item);
        }
    }
}
