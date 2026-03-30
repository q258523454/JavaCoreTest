package util.encrypt;

import java.util.Base64;

public enum BASE64Util {
    ;

    /**
     * Base64编码
     */
    public static String encryptBASE64(byte[] key) {
        return Base64.getEncoder().encodeToString(key);
    }

    /**
     * Base64解码
     */
    public static byte[] decryptBASE64(String key) {
        return Base64.getDecoder().decode(key);
    }

    /**
     * URL安全的Base64编码（用于URL参数）
     */
    public static String encryptBASE64UrlSafe(byte[] key) {
        return Base64.getUrlEncoder().encodeToString(key);
    }

    /**
     * 带换行的Base64编码（用于MIME格式）
     */
    public static String encryptBASE64Mime(byte[] key) {
        return Base64.getMimeEncoder().encodeToString(key);
    }
}