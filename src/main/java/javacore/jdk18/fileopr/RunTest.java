package javacore.jdk18.fileopr;

import com.alibaba.fastjson.JSON;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Comparator;

/**
 * @Author: zhang
 * @Date: 2019-07-31
 * @Version 1.0
 */
public class RunTest {
    public static void main(String[] args) {

        final String printDir = "G:\\我的下载\\test\\print";
        final String delFilePath = "G:\\我的下载\\test\\del.txt";

        final String srcFileCopy = "G:\\我的下载\\test\\copy.txt";
        final String dstFileCopy = "G:\\我的下载\\test\\copy_java.txt";

        final String srcDirCopy = "G:\\我的下载\\test\\copy";
        final String dstDirCopy = "G:\\我的下载\\test\\copy2";

        try {
//            printDirAllFile(printDir);

//            deleteFile(delFilePath);
//            deleteDirectory(dir);
//            copyFile(srcFileCopy, dstFileCopy);
            copyDirecotory(srcDirCopy, dstDirCopy);
        } catch (IOException e) {

            e.printStackTrace();
        }
        System.exit(0);

    }

    /**
     * 打印目录下所有的文件
     */
    public static void printDirAllFile(String srcDir) throws IOException {
        Path srcDirPath = Paths.get(srcDir);
        Files.walk(srcDirPath).forEach(subDirOrFile -> {
            System.out.println(subDirOrFile);
        });
    }

    /**
     * 删除单个文件
     */
    public static void deleteFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 删除整个目录
     */
    public static void deleteDirectory(String dirPath) throws IOException {
        Path path = Paths.get(dirPath);
        Files.walk(path).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
    }


    /**
     * 复制单个文件
     */
    public static void copyFile(String src, String dst) throws IOException {
        Path srcPath = Paths.get(src);
        Path dstPath = Paths.get(dst);
        Files.copy(srcPath, dstPath, StandardCopyOption.REPLACE_EXISTING);
    }


    /**
     * 复制整个目录(覆盖会报:DirectoryNotEmptyException)
     */
    public static void copyDirecotory(String srcDir, String dstDir) throws IOException {
        Path srcDirPath = Paths.get(srcDir);
        Path dstDirPath = Paths.get(dstDir);
        Files.walk(srcDirPath).forEach(subPath -> {
            try {
                /*
                 * path.relativize(subPath): 获取subPath在path中的相对路径
                 * path.resolve(subPath): 组装新路径,path/subPath
                 */
                Path relativeSubPath = srcDirPath.relativize(subPath);
                Path dst = dstDirPath.resolve(relativeSubPath);
                System.out.println("将:{" + subPath + "}复制为:{" + dst + "}");
                Files.copy(subPath, dst, StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception ex) {
                throw new RuntimeException("目录复制出错.", ex);
            }
        });
    }
}
