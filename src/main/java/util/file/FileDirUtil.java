package util.file;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;

/**
 * @Date: 2019-10-14
 * @Version 1.0
 */
@Slf4j
public enum FileDirUtil {
    ;

    /**
     * 获取文件名称,包含后缀
     * eg: 123.txt
     */
    public static String getFileFullName(String absolutePath) {
        File file = new File(absolutePath);
        return file.getName();
    }

    /**
     * 获取文件目录
     * eg: E:\JavaProject\local\JavaCoreTest\src\main\java\\util\file
     */
    public static String getParentPath(String absolutePath) {
        File file = new File(absolutePath);
        String parent = file.getParent();
        return parent;
    }

    /**
     * 获取纯文件名和后缀
     * 例如:  abc.123.txt
     * fileNameExtArr[0]: 纯文件名 abc.123
     * fileNameExtArr[1]: 文件后缀 txt
     */
    public static String[] getFileNameAndSuffixArr(String filePath) {
        String[] fileNameExtArr = new String[2];
        File file = new File(filePath);
        String fullName = file.getName();
        int dotIndex = fullName.lastIndexOf('.');
        if (dotIndex > 0) {
            // 文件名
            fileNameExtArr[0] = fullName.substring(0, dotIndex);
            // 文件后缀
            fileNameExtArr[1] = fullName.substring(dotIndex + 1);
        } else {
            log.info("file not found extension.");
        }
        return fileNameExtArr;
    }

    public static String getResourcePath(Class<?> cls, String name) {
        URL resource = cls.getResource(name);
        assert resource != null;
        File file = null;
        try {
            file = Paths.get(resource.toURI()).toFile();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return file.getAbsolutePath();
    }

    /**
     * 递归遍历指定路径下的指定格式, 返回 List<String>
     *
     * @param targetPath             文件路径
     * @param suffix                 文件格式后缀  eg: ".xml"
     * @param returnAbsolutePathList 全部指定文件的绝对路径列表(包含文件后缀)
     */
    public static List<String> getAbsolutePathList(String targetPath, String suffix, List<String> returnAbsolutePathList) {
        File root = new File(targetPath);
        // 非目录
        if (!root.isDirectory()) {
            returnAbsolutePathList.add(root.getAbsolutePath());
            return returnAbsolutePathList;
        }
        // 目录则递归遍历
        File[] files = root.listFiles();
        if (null != files) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // 递归xml
                    getAbsolutePathList(file.getAbsolutePath(), suffix, returnAbsolutePathList);
                } else if (file.getName().contains(suffix)) {
                    returnAbsolutePathList.add(file.getAbsolutePath());
                }
            }
        }
        return returnAbsolutePathList;
    }


    /**
     * 递归遍历指定路径下的指定格式, 返回 List<File>
     *
     * @param targetFilePath 文件路径
     * @param suffix         文件格式后缀  eg: ".xml"
     * @param fileList       全部指定文件的绝对路径列表(包含文件后缀)
     */
    public static List<File> getFileList(String targetFilePath, String suffix, List<File> fileList) {
        File root = new File(targetFilePath);
        // 非目录
        if (!root.isDirectory()) {
            fileList.add(root);
            return fileList;
        }
        // 目录则递归遍历
        File[] files = root.listFiles();
        if (null != files) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // 递归xml
                    getFileList(file.getAbsolutePath(), suffix, fileList);
                } else if (file.getName().contains(suffix)) {
                    fileList.add(file);
                }
            }
        }
        return fileList;
    }
}
