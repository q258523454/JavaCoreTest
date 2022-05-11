package util;

/**
 * @Date: 2019-06-05
 * @Version 1.0
 */
public enum IntegerUtil {
    ;


    /**
     * 返回 min-max 之间的随机数(近似)
     *
     * @param min
     * @param max
     * @return
     */
    public static int randomAnInteger(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}
