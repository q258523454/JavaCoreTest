package util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

/**
 * 安全数字随机数生成工具类
 */
public enum SecureNumberUtil {
    ;

    /**
     * 可替换为最强的随机算法: SecureRandom.getInstanceStrong()
     */
    private static final SecureRandom INSTANCE = createSecureRandom();


    private static SecureRandom createSecureRandom() {
        try {
            // 使用平台最强的随机算法
            return SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            // 降级到默认算法
            return new SecureRandom();
        }
    }

    /**
     * 数字字符集常量
     */
    private static final char[] DIGITS = "0123456789".toCharArray();

    private static final int DIGIT_COUNT = DIGITS.length;

    /**
     * 性能优化：预计算排除数组
     */
    private static final boolean[] ALL_DIGITS_ENABLED = new boolean[10];

    static {
        Arrays.fill(ALL_DIGITS_ENABLED, true);
    }

    /**
     * 生成单个随机数字（0-9）
     *
     * @return 0-9之间的随机数字
     */
    public static int randomDigit() {
        return INSTANCE.nextInt(DIGIT_COUNT);
    }

    /**
     * 生成指定范围的随机整数
     *
     * @param min 最小值（包含）
     * @param max 最大值（包含）
     * @return 范围内的随机整数
     */
    public static int randomInt(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("最小值不能大于最大值");
        }
        if (min == max) {
            return min;
        }

        return INSTANCE.nextInt(max - min + 1) + min;
    }

    /**
     * 生成指定范围的随机长整数
     */
    public static long randomLong(long min, long max) {
        if (min > max) {
            throw new IllegalArgumentException("最小值不能大于最大值");
        }

        long range = max - min + 1;
        long randomValue;

        // 处理大范围的情况
        if (range > 0 && range <= Integer.MAX_VALUE) {
            randomValue = INSTANCE.nextInt((int) range);
        } else {
            // 对于超大范围，使用更复杂的方法
            long randomLong = INSTANCE.nextLong();
            if (randomLong < 0) {
                randomLong = -randomLong;
            }
            randomValue = (randomLong % range);
        }

        return randomValue + min;
    }

    /**
     * 生成长度为length的随机数字字符串
     *
     * @param length 字符串长度
     * @return 随机数字字符串
     */
    public static String randomNumberString(int length) {
        return randomNumberString(length, ALL_DIGITS_ENABLED);
    }

    /**
     * 生成随机数字字符串，排除指定数字
     *
     * @param length        字符串长度
     * @param excludeDigits 要排除的数字数组
     * @return 随机数字字符串
     */
    public static String randomNumberString(int length, int... excludeDigits) {
        boolean[] allowedDigits = buildAllowedDigits(excludeDigits);
        return randomNumberString(length, allowedDigits);
    }

    /**
     * 生成随机数字字符串（内部方法，使用预计算数组）
     */
    private static String randomNumberString(int length, boolean[] allowedDigits) {
        if (length <= 0) {
            throw new IllegalArgumentException("长度必须大于0");
        }

        // 检查是否有可用的数字
        int availableCount = countAvailableDigits(allowedDigits);
        if (availableCount == 0) {
            throw new IllegalArgumentException("没有可用的数字");
        }

        // 构建可用数字数组（性能优化）
        int[] availableDigits = buildAvailableDigitsArray(allowedDigits, availableCount);

        StringBuilder result = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = INSTANCE.nextInt(availableCount);
            result.append(availableDigits[index]);
        }

        return result.toString();
    }

    /**
     * 生成随机数字字符串，首位不为0
     *
     * @param length 字符串长度
     * @return 随机数字字符串
     */
    public static String randomNumberStringNonZeroFirst(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("长度必须大于0");
        }

        if (length == 1) {
            // 生成长度为1且不为0的数字
            return String.valueOf(randomInt(1, 9));
        }

        StringBuilder result = new StringBuilder(length);

        // 第一位不为0
        result.append(randomInt(1, 9));

        // 剩余位可以是0-9
        for (int i = 1; i < length; i++) {
            result.append(randomDigit());
        }

        return result.toString();
    }

    /**
     * 构建允许的数字数组
     */
    private static boolean[] buildAllowedDigits(int[] excludeDigits) {
        boolean[] allowed = new boolean[10];
        Arrays.fill(allowed, true);

        if (excludeDigits != null) {
            for (int digit : excludeDigits) {
                if (digit >= 0 && digit <= 9) {
                    allowed[digit] = false;
                }
            }
        }

        return allowed;
    }

    /**
     * 统计可用的数字数量
     */
    private static int countAvailableDigits(boolean[] allowedDigits) {
        int count = 0;
        for (boolean allowed : allowedDigits) {
            if (allowed) count++;
        }
        return count;
    }

    /**
     * 构建可用数字数组
     */
    private static int[] buildAvailableDigitsArray(boolean[] allowedDigits, int availableCount) {
        int[] available = new int[availableCount];
        int index = 0;

        for (int i = 0; i < allowedDigits.length; i++) {
            if (allowedDigits[i]) {
                available[index++] = i;
            }
        }

        return available;
    }
}