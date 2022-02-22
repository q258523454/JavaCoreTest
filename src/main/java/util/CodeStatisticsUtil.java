package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.HashSet;


/**
 * 计算指定文件写了多少行代码
 * @Author: zhangj
 * @Date: 2019-10-09
 * @Version 1.0
 */
public enum CodeStatisticsUtil {
    ;
    private static final Logger logger = LoggerFactory.getLogger(CodeStatisticsUtil.class);

    private static HashMap<String, Integer> fileMap;            // 文件个数
    private static HashMap<String, Integer> lineMap;            // 文件行数
    private static HashMap<String, Integer> nonEmptyLineMap;    // 文件非空行数
    private static HashMap<String, Long> sizeMap;               // 文件大小

    // 待解析的扩展名 (如果不指定, 则会扫描所有文件类型)
    private static final String[] allTypes = {
            ".cc", ".c", ".cpp", ".h", ".java", ".xml", ".html", ".htm",
            ".php", ".py", ".asp", ".js", ".css", ".jsp", ".pl", ".cs", ".sql"
    };

    /**
     * 执行静态分析
     *
     * @param path        解析文件目录
     * @param ignorePaths 忽略指定文件列表
     */
    public static void statistics(String path, String... ignorePaths) {
        File file = new File(path);
        if (!file.exists()) {
            logger.info("{} doesn't exist!" +
                    "", path);
            return;
        }
        if (!file.isDirectory()) {
            logger.info("{} is not a directory!", path);
            return;
        }
        fileMap = new HashMap<>();
        lineMap = new HashMap<>();
        sizeMap = new HashMap<>();
        nonEmptyLineMap = new HashMap<>();

        // 忽略文件列表 HashSet自带去重
        HashSet<String> ignore = new HashSet<>();
        for (String s : ignorePaths) {
            ignore.add(new File(s).getAbsolutePath());
        }

        analyze(file, ignore);
        logger.info("Code statistics at {} :", path);
        String printOut = String.format("%-8s%-8s%-8s%-8s%-8s", "Type", "Files", "Lines", "Slocs", "Size");
        logger.info("{}", printOut);
        logger.info("-----------------------------------------------");
        long totalFileNum = 0;
        long totalLine = 0;
        long totalNonEmptyLine = 0;
        long totalSize = 0;
        for (String fileType : fileMap.keySet()) {
            printOut = String.format("%-8s%-8d%-8d%-8d%-8s",
                    fileType,
                    fileMap.getOrDefault(fileType, 0),
                    lineMap.getOrDefault(fileType, 0),
                    nonEmptyLineMap.getOrDefault(fileType, 0),
                    formatSize(sizeMap.getOrDefault(fileType, 0L))
            );
            logger.info("{}", printOut);

            // 汇总统计
            totalFileNum += fileMap.getOrDefault(fileType, 0);
            totalLine += lineMap.getOrDefault(fileType, 0);
            totalNonEmptyLine += nonEmptyLineMap.getOrDefault(fileType, 0);
            totalSize += sizeMap.getOrDefault(fileType, 0L);
        }
        logger.info("-----------------------------------------------");
        printOut = String.format("%-8s%-8d%-8d%-8d%-8s", "Total", totalFileNum, totalLine, totalNonEmptyLine, formatSize(totalSize));
        logger.info("{}", printOut);
    }

    /**
     * 格式化文件大小size, 输入文件大小单位 Byte
     *
     * @param fileByte 单位Byte
     * @return
     */
    private static String formatSize(long fileByte) {
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        if (fileByte < 1024) {
            fileSizeString = df.format((double) fileByte) + "B";
        } else if (fileByte < 1048576) {
            fileSizeString = df.format((double) fileByte / 1024) + "K";
        } else if (fileByte < 1073741824) {
            fileSizeString = df.format((double) fileByte / 1048576) + "M";
        } else {
            fileSizeString = df.format((double) fileByte / 1073741824) + "G";
        }
        return fileSizeString;
    }

    private static void analyze(File file, HashSet<String> ignore) {
        if (ignore.contains(file.getAbsolutePath())) {
            return;
        }

        // 递归遍历解析文件目录下的所有文件(包括文件夹)
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (null == files) {
                return;
            }
            for (File f : files) {
                analyze(f, ignore);
            }
            return;
        }

        // 判断是否支持解析该文件
        if (!isSupport(file)) {
            return;
        }

        String type = file.getPath().substring(file.getPath().lastIndexOf('.') + 1);
        // 按文件类型累加文件个数
        fileMap.put(type, fileMap.getOrDefault(type, 0) + 1);
        // 按文件类型累加文件大小
        sizeMap.put(type, sizeMap.getOrDefault(type, 0L) + file.length());
        // 按文件类型统计文件行数
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                lineMap.put(type, lineMap.getOrDefault(type, 0) + 1);
                // 按文件类型统计非空行数
                if (!line.isEmpty()) {
                    nonEmptyLineMap.put(type, nonEmptyLineMap.getOrDefault(type, 0) + 1);
                }
            }
        } catch (Exception ex) {
            logger.error("Read file occurs error:", ex);
        }
    }

    /**
     * 判断是否支持改文件格式(判断后缀)
     *
     * @param file 待判断的文件
     * @return
     */
    public static boolean isSupport(File file) {
        // 如果不添加后缀, 默认扫描全部文件类型
        if (0 == allTypes.length) {
            return true;
        }
        for (String type : allTypes) {
            if (file.getPath().endsWith(type)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        String path = ".";
        if (args.length > 0) {
            path = args[0];
        }
        statistics(path);
        System.exit(0);
    }

}

