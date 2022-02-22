package util.file;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.List;

/**
 * @Date: 2019-10-14
 * @Version 1.0
 */
@Slf4j
public enum FileUtil {
    ;

    /**
     * 递归遍历指定路径下的指定格式
     *
     * @param filePath 文件路径
     * @param suffix   文件格式后缀  eg: ".xml"
     * @param filelist 全部指定文件的绝对路径列表(包含文件后缀)
     * @return
     */
    public static List<String> getFileList(String filePath, String suffix, List<String> filelist) {
        File root = new File(filePath);
        // 非目录
        if (!root.isDirectory()) {
            filelist.add(root.getAbsolutePath());
            return filelist;
        }
        // 目录则递归遍历
        File[] files = root.listFiles();
        if (null != files) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // 递归xml
                    getFileList(file.getAbsolutePath(), suffix, filelist);
                } else if (file.getName().contains(suffix)) {
                    filelist.add(file.getAbsolutePath());
                }
            }
        }
        return filelist;
    }
}
