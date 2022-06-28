package com.poo0054.design.proxy.jdkproxy;

import lombok.Data;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk代理，必须要有接口才能用。
 * {@link com.poo0054.design.proxy.cglibproxy.CglibProxyDemo} 不用接口也可以使用
 *
 * @author zhangzhi
 * @version 1.0
 * @since 2022/6/28 15:49
 */

public class JdkProxyDemo {
    @Test
    public void test1() {
        AbstractSubject abstractSubject = new Subject();
        DjkProx1 djkProx1 = new DjkProx1();
        djkProx1.setTarget(abstractSubject);
        AbstractSubject proxyInstance = (AbstractSubject) Proxy.newProxyInstance(Subject.class.getClassLoader(), Subject.class.getInterfaces(), djkProx1);
        proxyInstance.send();
    }

    @Test
    public void test2() {
        DjkProxy2 djkProxy2 = new DjkProxy2();
        AbstractSubject abstractSubject = new Subject();
        djkProxy2.setTarget(abstractSubject);
        djkProxy2.send();
    }

    /**
     * 代理，写法1：只返回代理对象，然后自己用代理对象做一些事情
     */
    @Data
    class DjkProx1 implements InvocationHandler {
        private Object target;

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("DjkProx1代理之前");
            return method.invoke(target, args);
        }
    }

    /**
     * 代理,写法2，直接执行方法，不关注代理对象
     */
    @Data
    class DjkProxy2 implements AbstractSubject {

        private Object target;

        @Override
        public void send() {
            AbstractSubject abstractSubject = (AbstractSubject) newProxy();
            abstractSubject.send();
        }

        private Object newProxy() {
            return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), (proxy, method, args) -> {
                System.out.println("DjkProxy2代理之前");
                return method.invoke(target, args);
            });
        }

    }

    /**
     * 抽象主题
     */
    interface AbstractSubject {
        void send();
    }

    /**
     * 主题
     */
    class Subject implements AbstractSubject {
        public void send() {
            System.out.println("我在发消息");
        }
    }
}
