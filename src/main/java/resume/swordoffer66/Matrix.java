package resume.swordoffer66;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2018-12-25
 */
public class Matrix {

    public static void main(String[] args) {

        int[][] p = new int[3][];

        for (int i = 0; i < p.length; i++) {
            int[] t = new int[i+1];
            for (int j = 0; j < t.length; j++) {
                t[j] = j+1;
            }
            p[i] = t;
        }

        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p[i].length; j++) {
                System.out.print(p[i][j] + " ");
            }
            System.out.println();
        }
    }
}
