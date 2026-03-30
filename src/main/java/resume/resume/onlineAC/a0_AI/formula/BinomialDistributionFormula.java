package resume.resume.onlineAC.a0_AI.formula;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class BinomialDistributionFormula {

    /**
     * LA29 二项分布概率
     * 公式: P(X=k) = C(n, k) * p^k * (1-p)^(n-k)
     * <a href="https://www.nowcoder.com/practice/4c8d77d078f9468ab89df01af4edc638?tpId=378&tqId=11121284&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26tab%3DAI%25E7%25AF%2587%26topicId%3D378">...</a>
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] split1 = line.split(" ");
            int n = Integer.parseInt(split1[0]);
            int k = Integer.parseInt(split1[1]);
            double p = Double.parseDouble(split1[2]);

            double res = cnk(n, k) * Math.pow(p, k) * Math.pow(1 - p, n - k);
            BigDecimal bigDecimal = new BigDecimal(res);
            bigDecimal = bigDecimal.setScale(5, RoundingMode.HALF_UP);
            System.out.println(bigDecimal);
        }
    }

    /**
     * 计算 C(n, k)
     */
    public static double cnk(int n, int k) {
        double v1 = calcFactorial(n, k);
        double v2 = calcFactorial(k, k);
        double res = v1 / v2;
        return res;
    }

    /**
     * 计算n的m阶乘
     * n!=(n,n)
     */
    public static double calcFactorial(int n, int m) {
        if (n == 1 || m <= 0) {
            return 1;
        }
        return n * calcFactorial(n - 1, m - 1);
    }
}
