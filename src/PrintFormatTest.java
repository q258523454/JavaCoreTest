import java.util.Date;

/**
 * Created by mac on 17/7/17.
 */
public class PrintFormatTest {

    public static void main(String args[]){

        System.out.printf("%f\t%f\n",10.0/3,-10.0/3);

        System.out.printf("% f\t%(f\n",10.0/3,-10.0/3);

        System.out.printf("% f\t%(f\n",10.0/3,-10.0/3);

        System.out.printf("%1$s \t %2$td %2$tm %2$tY","Date:",new Date());

        System.out.printf("\n %s \t %td %<tm %<tY","Date:",new Date());

    }


}



