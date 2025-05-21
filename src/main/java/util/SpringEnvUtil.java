package util;


/**
 * @Description spring环境配置工具
 * @date 2020-05-08 20:27
 * @modify
 */
public enum SpringEnvUtil {
    ;

    /**
     * @Description: 判断是否本地启动 配置 active:loc
     * @date 2020/5/7 17:38
     * @return boolean
     */
    public static boolean isLoc() {
        String[] activeProfiles = SpringContextHolder.getApplicationContext().getEnvironment().getActiveProfiles();
        String activeName = activeProfiles[0];
        if (null != activeName && activeName.toLowerCase().contains("loc")) {
            return true;
        }
        return false;
    }
}
