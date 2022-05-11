package resume.question.ACM_huazi.base;

import java.util.Scanner;

/**
 * @Description
 * @author zhang
 * @date 2022-04-26 15:18
 * @modify
 */
public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextFloat()) {
            String str = sc.nextLine();
            String[] splitList = str.split(" ");
            int len = splitList.length;
            String lastWord = splitList[len - 1];
            System.out.println(lastWord.length());
        }
    }

}
