package javacore.base.t0_try_catch;

public class TryCatchTest {

    /**
     * 总结:
     * try-catch-finally
     * 不管有无异常, 执行顺序都是 try-catch(有异常)-finally
     * return结果值最终确定来自 finally->try->catch(有异常)
     */
    public static void main(String[] args) {
        System.out.println("---------------------------");
        tryCatchTest1();
        System.out.println("---------------------------");
        StringBuilder sb = new StringBuilder("test");
        System.out.println(tryCatchReturn1(sb));
        System.out.println(sb);
        System.out.println("---------------------------");
        sb = new StringBuilder("test");
        System.out.println(tryCatchReturn2(sb));
        System.out.println(sb);
        System.out.println("---------------------------");
    }

    public static void tryCatchTest1() {
        int a = 0;

        int b = 0;
        try {
            System.out.println("执行-try");
            a++;
            b++;
            throw new RuntimeException("xx");
        } catch (Exception ex) {
            System.out.println("执行-catch");
            b++;
        } finally {
            System.out.println("执行-finally");
            b++;
        }
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }

    /**
     * 无异常情况:
     * 由于没有异常 catch直接跳过
     * 执行顺序还是 try-catch(有异常)-finally, 返回 finally 的 return
     */
    public static StringBuilder tryCatchReturn1(StringBuilder stringBuilder) {
        try {
            System.out.println("执行-try");
            return stringBuilder.append("-try");
        } catch (Exception ex) {
            System.out.println("执行-catch");
            return stringBuilder.append("-catch");
        } finally {
            System.out.println("执行-finally");
            return stringBuilder.append("-finally");
        }
    }

    /**
     * 有异常情况:
     * catch-finally 都有执行 return
     * 执行顺序还是 try-catch(有异常)-finally, 返回 finally 的 return
     */
    public static StringBuilder tryCatchReturn2(StringBuilder stringBuilder) {
        try {
            System.out.println("执行-try");
            throw new RuntimeException("xx");
        } catch (Exception ex) {
            System.out.println("执行-catch");
            return stringBuilder.append("-catch");
        } finally {
            System.out.println("执行-finally");
            return stringBuilder.append("-finally");
        }
    }

}
