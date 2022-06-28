package com.poo0054.design.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    Object object;

    public ProxyFactory(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Object instance() {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("我是在代理之前做的事情");
                        Object invoke = method.invoke(object, args);
                        System.out.println("我是在代理之后做的事情");
                        return invoke;
                    }
                }
        );
    }
}
