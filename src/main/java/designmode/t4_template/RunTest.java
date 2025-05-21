package designmode.t4_template;

public class RunTest {
    public static void main(String[] args) {

        /**
         * 模板方法
         * 总结: 抽象类(实现接口)中定义执行模板.
         */
        PersonA personA = new PersonA();
        personA.doBusiness();

        PersonB personB = new PersonB();
        personB.doBusiness();
    }
}
