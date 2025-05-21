

package util.file;

import lombok.SneakyThrows;
import util.encrypt.BASE64Util;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public enum FileReadUtil {
    ;

    @SneakyThrows
    public static void main(String[] args) {
        // 方式1: File
        readFileByFile();

        // 方式2: FileReader
        readFileByFileReader();

        // 方式3: BufferedReader
        readFileByBufferedReader();

        // 方式4: Scanner
        readFileByScanner();

        // 计算文件byte的哈希值
        calcSha256();
        calcMD5();
    }


    /**
     * File
     */
    private static void readFileByFile() throws IOException {
        String filePath = "E:\\JavaProject\\local\\JavaCoreTest\\src\\main\\java\\practice\\readfile\\file2.sql";
        Path path = Paths.get(filePath);
        List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
        for (String allLine : allLines) {
            // System.out.println(allLine);
        }

        // 也可以直接读取整个字节
        byte[] bytes = Files.readAllBytes(path);
        System.out.println(new String(bytes));
    }

    /**
     * FileReader
     */
    private static void readFileByFileReader() throws IOException {
        String filePath = "E:\\JavaProject\\local\\JavaCoreTest\\src\\main\\java\\practice\\readfile\\file1.txt";
        File file = new File(filePath);
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                // 逐行读取
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.close(br);
            IOUtils.close(fr);
        }


    }

    /**
     * BufferedReader
     */
    private static void readFileByBufferedReader() throws IOException {
        String filePath = "E:\\JavaProject\\local\\JavaCoreTest\\src\\main\\java\\practice\\readfile\\file1.txt";
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(inputStreamReader);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    /**
     * Scanner
     */
    private static void readFileByScanner() throws IOException {
        String filePath = "E:\\JavaProject\\local\\JavaCoreTest\\src\\main\\java\\practice\\readfile\\file1.txt";
        Path path = Paths.get(filePath);
        Scanner scanner = new Scanner(path);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }

    private static void calcSha256() throws IOException {
        String filePath = "F:\\我的下载\\0923e81d1c6e434aa8ddf221d412dabe.jpg";
        Path path = Paths.get(filePath);
        byte[] bytes = Files.readAllBytes(path);
        InputStream sha256Stream = new ByteArrayInputStream(bytes);
        DigestUtils digestUtils = new DigestUtils(MessageDigestAlgorithms.SHA_256);
        String s = digestUtils.digestAsHex(sha256Stream);
        System.out.println("文件 SHA256: " + s);
    }

    private static void calcMD5() throws IOException, DecoderException {
        String filePath = "F:\\我的下载\\0923e81d1c6e434aa8ddf221d412dabe.jpg";
        Path path = Paths.get(filePath);
        byte[] bytes = Files.readAllBytes(path);
        InputStream sha256Stream = new ByteArrayInputStream(bytes);
        DigestUtils digestUtils = new DigestUtils(MessageDigestAlgorithms.MD5);
        String md5 = digestUtils.digestAsHex(sha256Stream);
        System.out.println("文件 MD5: " + md5);
        byte[] hexByte = Hex.decodeHex(md5.toCharArray());
        System.out.println(BASE64Util.encode(hexByte));
    }
}
