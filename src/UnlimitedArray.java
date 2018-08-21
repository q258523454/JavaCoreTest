/**
 * Created by mac on 17/7/18.
 */
public class UnlimitedArray {

    public static void main(String args[]) {
        int MAX = 5;

        int[][] test = new int[MAX][];

        System.out.println("len=" + test.length);


        for (int i = 0; i < MAX; i++) {
            test[i] = new int[i+1];
        }

        for (int[] rows : test) {

            for (int e : rows) {
                System.out.printf(" "+e);
            }
            System.out.println();
        }
    }

}

