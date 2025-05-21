package designmode.t1_singleton.b_lazy;

public class RunTest {
    public static void main(String[] args) {
        for (int i = 0; i <3; i++) {
            SingletonLazy instance = SingletonLazy.getSingletonLazy();
        }
    }
}
