package util;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public enum StreamUtil {
    ;

    /**
     * 从输入流读取若干字节
     */
    public static byte[] readBytes(InputStream is, int length) {
        int pos = 0;
        int remainingLength = length;
        byte[] bytes = new byte[length];

        try {
            while (remainingLength > 0) {
                int n = is.read(bytes, pos, remainingLength);
                if (n < 0) {
                    /*连接已断开，直接抛出运行时异常*/
                    throw new RuntimeException("从输入流读取报文数据失败，对方主动关闭连接");
                }
                remainingLength -= n;
                pos += n;
            }
        } catch (IOException e) {
            throw new RuntimeException("从输入流读取报文数据失败（" + e.getMessage() + "）");
        }

        return bytes;
    }

    /**
     * 从输入流读取若干字节，返回读到的字符数量
     */
    public static int readBytes(InputStream is, int length, byte[] bytes) {
        int pos = 0;
        int remainingLength = length;

        try {
            while (remainingLength > 0) {
                int n = is.read(bytes, pos, remainingLength);
                if (n < 0) {
                    return pos;
                }
                remainingLength -= n;
                pos += n;
            }
        } catch (IOException e) {
            throw new RuntimeException("从输入流读取报文数据失败（" + e.getMessage() + "）");
        }

        return pos;
    }

    /**
     * 从流中读取数据，直到流结束
     */
    public static byte[] readStream(InputStream is) {
        try {
            byte[] buf = new byte[1024];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            for (int len = is.read(buf); len > 0; len = is.read(buf)) {
                baos.write(buf, 0, len);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 跳过部分字节
     */
    public static long skip(InputStream is, int length) {
        try {
            return is.skip(length);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
