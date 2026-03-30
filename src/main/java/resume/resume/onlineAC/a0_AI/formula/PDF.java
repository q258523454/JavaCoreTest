package resume.resume.onlineAC.a0_AI.formula;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class PDF {

    /**
     * LA30 正态分布PDF计算器
     * 公式: f(x) = (1/σ*√(2π)) * e^(-((x-μ)²/(2σ²)))
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] split1 = line.split(" ");
            double x = Double.parseDouble(split1[0]);
            double u = Double.parseDouble(split1[1]);
            double o = Double.parseDouble(split1[2]);
            double calc = calc(x, u, o);
            BigDecimal bigDecimal = new BigDecimal(calc);
            bigDecimal = bigDecimal.setScale(5, RoundingMode.HALF_UP);
            System.out.println(bigDecimal);
        }
    }

    /**
     * f(x) = (1/σ*√(2π)) * e^(-((x-μ)²/(2σ²)))
     */
    public static double calc(double x, double u, double o) {
        double p1 = 1 / (o * Math.sqrt(2 * Math.PI));
        double p2 = Math.pow(Math.E, -(Math.pow(x - u, 2) / (2 * o * o)));
        return p1 * p2;
    }
}
