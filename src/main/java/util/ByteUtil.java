
package util;

import java.util.Arrays;

public enum ByteUtil {
    ;

    /**
     * 字节数组拼接
     */
    public static byte[] combine(byte[] firstBytes, byte[] secondBytes) {
        byte[] newArray = Arrays.copyOf(firstBytes, firstBytes.length + secondBytes.length);
        System.arraycopy(secondBytes, 0, newArray, firstBytes.length, secondBytes.length);
        return newArray;
    }
}
