package javacore.base.t2_regulation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: zhangj
 * @Date: 2019-10-11
 * @Version 1.0
 */
public class regexRepalce {
    private static final Logger logger = LoggerFactory.getLogger(regexRepalce.class);

    private static Pattern pattern = Pattern.compile("\\#(.*?)\\#");

    public static void main(String[] args) {
        String filetext = "String is : #a# #b# #c# #d# ";
        Matcher m = pattern.matcher(filetext);
        while (m.find()) {
            // m.group(0)包括#这两个字符, 相当于 $0
            System.out.println(m.group(0));
            // m.group(1)不包括#这两个字符, 相当于 $1
            System.out.println(m.group(1));
            filetext = filetext.replace(m.group(0), m.group(1));
        }
        System.out.println(filetext);
    }
}
