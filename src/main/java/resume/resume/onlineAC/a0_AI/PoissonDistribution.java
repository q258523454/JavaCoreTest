package resume.resume.onlineAC.a0_AI;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class PoissonDistribution {
    /**
     * 泊松分布计算
     * 公式= {pow(λ,k)*pow(e,-λ)}/k!
     * <a href="https://www.nowcoder.com/practice/62cefdecf3554378a8c2cd9f77faa13c?tpId=378&tqId=11121279&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26tab%3DAI%25E7%25AF%2587%26topicId%3D378">...</a>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] split1 = line.split(" ");
            int k = Integer.parseInt(split1[0]);
            int lamuda = Integer.parseInt(split1[1]);

            double res = (Math.pow(lamuda, k) * Math.pow(Math.E, -lamuda)) / calcK(k);
            BigDecimal bigDecimal = new BigDecimal(res);
            bigDecimal = bigDecimal.setScale(5, RoundingMode.HALF_UP);
            System.out.println(bigDecimal);
        }
    }

    public static int calcK(int k) {
        if (k < 0) {
            throw new IllegalArgumentException();
        }
        // 0的阶乘=1
        if (k <= 1) {
            return 1;
        }
        return k * calcK(k - 1);
    }
}
