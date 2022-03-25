package designmode.t3_proxy.dynamicproxy.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// JDK代理, 实现InvocationHandler, 被代理对象必须是实现类.
@Slf4j
public class JdkDynamicProxy implements InvocationHandler {

    private Object obj;

    public Object bind(Object obj) {
        this.obj = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    /**
     * 执行被代理对象的任何接口方法都会经过该方法
     * @param proxy 代理对象的引用
     * @param method 当前执行的方法
     * @param args 当前执行方法所需的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("Jdk:加糖");
        Object object = method.invoke(obj, args);
        return object;
    }
}
