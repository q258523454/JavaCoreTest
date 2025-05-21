package designmode.t3_proxy.dynamicproxy.proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class CglibDynamicProxy implements MethodInterceptor {

    /**
     * 回调函数
     * @param proxy 当前执行方法的代理对象
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] params, MethodProxy proxy) throws Throwable {
        log.info("Cglib:加糖");
        Object result = proxy.invokeSuper(obj, params);
        return result;
    }
}

