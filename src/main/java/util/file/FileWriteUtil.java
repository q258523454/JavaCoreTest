package util.file;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public enum FileWriteUtil {
    ;

    /**
     * 写入数据 Files 方式
     */
    public static void writeFile(String targetPath, String content) {
        byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
        writeFile(targetPath, bytes);
    }

    /**
     * 写入数据 Buffer方式
     */
    public static void writeFileBuffer(String absFilePath, String content) {
        byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
        writeFileBuffer(absFilePath, bytes);
    }

    public static void writeFile(String targetPath, byte[] bytes) {
        try {
            Path path = Paths.get(targetPath);
            // 如果文件不存在，会自动创建
            Files.write(path, bytes);
            System.out.println("内容已成功写入文件: " + targetPath);
        } catch (IOException e) {
            System.err.println("写入文件时出错: " + e.getMessage());
        }
    }

    public static void writeFileBuffer(String absFilePath, byte[] bytes) {
        Path path = Paths.get(absFilePath);
        try (BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(path))) {
            bos.write(bytes);
        } catch (IOException e) {
            System.err.println("写入文件时出错: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        writeFile("E:\\JavaProject\\local\\JavaCoreTest\\src\\main\\java\\util\\file\\123.txt", "撒的发生大");
        writeFileBuffer("E:\\JavaProject\\local\\JavaCoreTest\\src\\main\\java\\util\\file\\abc.txt", "打算范德萨");
    }
}
