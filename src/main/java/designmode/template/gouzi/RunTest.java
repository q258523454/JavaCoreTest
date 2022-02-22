package designmode.template.gouzi;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-21
 */
public class RunTest {
    public static void main(String[] args) {
        OrdinaryHouse ordinaryHouse = new OrdinaryHouse("普通房子", false);
        ordinaryHouse.build();

        PollVillaHouse villaHouse = new PollVillaHouse("别墅(带泳池)", true);
        villaHouse.build();
    }
}
