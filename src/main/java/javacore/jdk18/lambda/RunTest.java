package javacore.jdk18.lambda;

public class RunTest {

    interface MathOperation {
        int operation(int a, int b);
    }

    public static void main(String[] args) {
        // 传统写法
        MathOperation addOpt_older = new MathOperation() {
            @Override
            public int operation(int a, int b) {
                return a + b;
            }
        };
        // lambda写法1
        MathOperation addOpt1 = (a, b) -> a + b;
        // lambda写法2
        MathOperation addOpt2 = (int a, int b) -> a + b;
        // lambda写法3
        MathOperation addOpt3 = (a, b) -> {
            return a + b;
        };

        System.out.println(addOpt1.operation(1, 2));
    }
}
