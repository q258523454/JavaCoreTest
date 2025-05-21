package util.regex;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public enum PatternUtil {
    ;

    /**
     * @param str    待替换的字符串
     * @param regex  正则表达式
     * @param newStr 用来替换的字符串, 可以是 $1
     * @Description 利用正则表达式替换字符串
     * @date 2020年07月24日 14:54
     */
    public static String replace(String str, String regex, String newStr) {
        return Pattern.compile(regex).matcher(str).replaceAll(newStr);
    }


    /**
     * 高级匹配查找
     *
     * @param str   字符串
     * @param regex 正在表达式
     * @param $i    0:表示整个匹配 1:表示第一个括号里面内容(), 依次类推
     * @return
     */
    public static List<String> extract(String str, String regex, int $i) {
        Matcher matcher = Pattern.compile(regex).matcher(str);
        List<String> list = new ArrayList<>(10);
        // find all matches
        while (matcher.find()) {
            list.add(matcher.group($i));
        }
        return list;
    }

    /**
     * 打印所有匹配
     */
    public static void printAllReg(String str, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(str);
        List<String> list = new ArrayList<>(10);
        // find all matches
        while (matcher.find()) {
            list.clear();
            for (int i = 0; i <= matcher.groupCount(); i++) {
                list.add(matcher.group(i));
            }
            log.info(JSON.toJSONString(list));
        }
    }


    // ------------------------ Test ------------------------
    public static void replaceTest() {
        String sql = "@Select(\"aa\")";
        sql = sql.toLowerCase();
        String regex = "@select\\s*\\(\\s*\"(.*)\"\\s*\\)";
        List<String> list = new ArrayList<>();
        // Regex: @Select\s*\(\s*"(.*)"\s*\), 提取 @Select("aa") ----> aa
        String $1 = PatternUtil.replace(sql, regex, "$1");
        log.info("replaceTest():" + $1);
    }

    /**
     * matcher 基础测试2
     */
    public static void extractTest2() {
        String str = " * @ 123456 :   zhangj @   321244 :   2020-08-11";
        // @后面的出现的第一个连续的数字
        String regex = "@\\s*([0-9]+)\\s*";
        Matcher matcher = Pattern.compile(regex).matcher(str);
        List<String> extract = extract(str, regex, 1);
        log.info(JSON.toJSONString(extract));
    }

    /**
     * matcher 基础测试1
     */
    private static void extractTest1() {
        String str = "      select id        from student        for    update abc";
        String regex = "\\s*for\\s*update\\s*([a-zA-Z]*)";
        Matcher matcher = Pattern.compile(regex).matcher(str);
        while (matcher.find()) {
            String group = matcher.group(0);
            String group1 = matcher.group(1);
            System.out.println(group);
            System.out.println(group1);
        }
    }

    /**
     * .+? 非贪婪模式(惰性匹配),匹配最小长度
     */
    public static void minLengthMatchTest() {
        // .+? 是"惰性匹配"，? 在这里是一个修饰符，它让 + 变为非贪婪模式, 表示匹配最短的连续子串（至少 1 个字符)
        // \\2 这是一个反向引用，表示引用第2个捕获组'(\d+)'匹配到的内容
        // \\2{5,}, 表示第2个捕获组的重复次数, 加上初始的 1 次匹配，总共需要 至少 6 次重复
        String regex = "([a-zA-Z]+)(.+?)\\2{5,}";
        List<String> list = new ArrayList<>();
        // (lisi)(a){5,}
        list.add("lisiaaaaaaaa");
        // (zhangxiaofan)(12){5,}
        list.add("zhangxiaofan121212121212");
        // (wangwu)(123abc){5,}
        list.add("wangwu123abc123abc123abc123abc123abc123abc123abc");

        for (String str : list) {
            System.out.println("匹配字符串:" + str);
            Matcher matcher = Pattern.compile(regex).matcher(str);
            while (matcher.find()) {
                String group0 = matcher.group(0);
                String group1 = matcher.group(1);
                String group2 = matcher.group(2);
                System.out.println("group0：" + group0);
                System.out.println("group1 ([a-zA-Z]+)：" + group1);
                System.out.println("group2 (.+?)：" + group2);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        // replaceTest();
        // extractTest1();
        // extractTest2();
        minLengthMatchTest();
    }
}