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
     * @Description 利用正则表达式替换字符串
     * @date 2020年07月24日 14:54
     * @param str 待替换的字符串
     * @param regex 正则表达式
     * @param newStr 用来替换的字符串, 可以是 $1
     */
    public static String replace(String str, String regex, String newStr) {
        return Pattern.compile(regex).matcher(str).replaceAll(newStr);
    }


    /**
     * 高级匹配查找
     * @param str 字符串
     * @param regex 正在表达式
     * @param $i 0:表示整个匹配 1:表示第一个括号里面内容(), 依次类推
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


    // ------------------------ Test  BEGIN------------------------
    public static void replaceTest() {
        String sql = "@Select(\"aa\")";
        sql = sql.toLowerCase();
        String regex = "@select\\s*\\(\\s*\"(.*)\"\\s*\\)";
        List<String> list = new ArrayList<>();
        // Regex: @Select\s*\(\s*"(.*)"\s*\), 提取 @Select("aa") ----> aa
        String $1 = PatternUtil.replace(sql, regex, "$1");
        log.info($1);
    }

    public static void extractTest() {
        String str = " * @ 123456 :   zhangj @   321244 :   2020-08-11";
        // @后面的出现的第一个连续的数字
        String regex = "@\\s*([0-9]+)\\s*";
        Matcher matcher = Pattern.compile(regex).matcher(str);
        List<String> extract = extract(str, regex, 1);
        log.info(JSON.toJSONString(extract));
    }
    // ------------------------ Test  END------------------------


    /**
     * @Description
     * @date 2020年08月12日 9:53
     * @param args
     */
    public static void main(String[] args) {

        replaceTest();
        extractTest();
        String str = "      select id        from student        for    update";
        String regex = "\\s*for\\s*update\\s*([a-zA-Z]*)";
        Matcher matcher = Pattern.compile(regex).matcher(str);
        while (matcher.find()) {
            String group = matcher.group(0);
            String group1 = matcher.group(1);
            System.out.println("group：" + group);
            System.out.println("group1：" + group1);
        }
    }

}