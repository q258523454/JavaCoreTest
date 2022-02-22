package designmode.proxy.dynamicproxy.proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibDynamicProxy implements MethodInterceptor {

    /**
     * 回调函数
     */
    @Override
    public Object intercept(Object obj, Method method,
                            Object[] params, MethodProxy proxy) throws Throwable {
        System.out.println("Cglib Before");
        Object result = proxy.invokeSuper(obj, params);
        System.out.println("Cglib After");
        return result;
    }
}

