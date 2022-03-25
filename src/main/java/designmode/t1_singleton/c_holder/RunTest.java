package designmode.t1_singleton.c_holder;

public class RunTest {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Singleton instance = Singleton.getInstance();
        }
    }
}
