import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by mac on 17/7/17.
 */
public class ForEachTest {
    public static void main(String agrs[]){

        String[] testStr=new String[10];
        int i=0;
        for (String e : testStr) {
            e="ttt"+i;
            System.out.println(e);
            i++;
            if(i==10){
                System.out.println(Arrays.toString(testStr));
            }
        }

        System.out.println(Arrays.toString(testStr));

    }

}
