package com.poo0054.design.proxy.staticproxy;

import lombok.Data;
import org.junit.Test;

/**
 * <br/>代理模式的主要角色如下。
 * <br/>抽象主题（abstractSubject）类：通过接口或抽象类声明真实主题和代理对象实现的业务方法。
 * <br/>真实主题（Subject）类：实现了抽象主题中的具体业务，是代理对象所代表的真实对象，是最终要引用的对象。
 * <br/>代理（Proxy）类：提供了与真实主题相同的接口，其内部含有对真实主题的引用，它可以访问、控制或扩展真实主题的功能。
 *
 * @author zhangzhi
 * @version 1.0
 * @since 2022/6/28 15:44
 */
public class StaticProxyDemo {

    @Test
    public void test() {
        AbstractSubject subject = new Subject();
        StaticProxy staticProxy = new StaticProxy();
        staticProxy.setAbstractSubject(subject);
        staticProxy.proxyMethod();
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

    /**
     * 代理
     */
    @Data
    class StaticProxy {
        private AbstractSubject abstractSubject;

        public void proxyMethod() {
            System.out.println("代理之前");
            abstractSubject.send();
            System.out.println("代理之后");
        }
    }

}

