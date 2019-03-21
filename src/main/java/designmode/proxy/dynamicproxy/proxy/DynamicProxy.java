package designmode.proxy.dynamicproxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-20
 */

// JDK默认代理, 实现InvocationHandler
public class DynamicProxy implements InvocationHandler {
    private Object obj;

    public Object bind(Object obj) {
        this.obj = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是动态代理");
        Object object = method.invoke(obj, args);
        return object;
    }
}
