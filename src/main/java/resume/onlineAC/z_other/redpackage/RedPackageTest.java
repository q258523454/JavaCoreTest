
package resume.onlineAC.z_other.redpackage;

import java.math.BigDecimal;


public class RedPackageTest {
    /**
     * 规则:
     * 1.每个用户至少能获得0.01元
     * 2.红包抢到的额度范围在：{0.01,剩余平均值*2}之间
     * eg: 100块钱，10个红包，平均值是10块钱，红包额度在{0.01,20}之间
     * 当前面3个红包总共被领了40块钱时，剩下60块钱，总共7个红包，那么这7个红包的额度在：0.01～（60/7*2）=0.01~17.14之间。
     */
    public static BigDecimal getRandomMoney(RedPack redPackageObject) {
        if (redPackageObject.leftNum == 1) {
            redPackageObject.leftNum--;
            return redPackageObject.leftMoney;
        }

        BigDecimal random = BigDecimal.valueOf(Math.random());

        // 红包最小金额0.01,每个人至少能拿到0.01
        BigDecimal min = BigDecimal.valueOf(0.01);

        // 红包均值
        BigDecimal average = redPackageObject.leftMoney.divide(BigDecimal.valueOf(redPackageObject.leftNum), BigDecimal.ROUND_DOWN);
        // 红包均值乘以2
        BigDecimal max1 = average.multiply(new BigDecimal(2));

        // 剩下的每个人至少有0.01,即要保证每个人能拿到0.01元红包
        BigDecimal minLeftMoney = min.multiply(BigDecimal.valueOf(redPackageObject.leftNum - 1));
        BigDecimal max2 = redPackageObject.leftMoney.subtract(minLeftMoney);

        BigDecimal max = (max1.compareTo(max2) < 0) ? max1 : max2;

        BigDecimal money = max.multiply(random).setScale(2, BigDecimal.ROUND_DOWN);
        money = money.compareTo(min) < 0 ? min : money;

        redPackageObject.leftNum--;
        redPackageObject.leftMoney = redPackageObject.leftMoney.subtract(money);
        return money;
    }

    static class RedPack {
        /**
         * 剩余的红包数量
         */
        private int leftNum;
        /**
         * 剩余的金额,微信红包最多两位小数
         */
        private BigDecimal leftMoney;

        public RedPack(int leftNum, String leftMoney) {
            this.leftNum = leftNum;
            this.leftMoney = new BigDecimal(leftMoney);
            if (!isWeChatRedPackage(this.leftMoney)) {
                throw new IllegalArgumentException("微信红包最多两位小数，且不超过200");
            }
        }
    }

    /**
     * 判断是否是微信红包,至多2位整数(不超过200),2位小数
     */
    public static boolean isWeChatRedPackage(BigDecimal num) {
        int signum = num.signum();
        int scale = num.stripTrailingZeros().scale();
        // 微信红包必须为正整数,且小数位不能超过2位
        if (signum != 1 || scale > 2) {
            return false;
        }
        // 微信红包不能超过200
        if (num.compareTo(new BigDecimal("200")) > 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        RedPack moneyPackage = new RedPack(5, "200.00");
        while (moneyPackage.leftNum != 0) {
            System.out.print(getRandomMoney(moneyPackage) + "   ");
        }
        System.out.println();
    }
}