package designmode.proxy.dynamicproxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// JDK代理, 实现InvocationHandler, 被代理对象必须是实现类
public class JdkDynamicProxy implements InvocationHandler {
    private Object obj;

    public Object bind(Object obj) {
        this.obj = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Jdk Dynamic Proxy");
        Object object = method.invoke(obj, args);
        return object;
    }
}
