package com.poo0054.design.proxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.Method;


/**
 * cglib代理
 *
 * @author zhangzhi
 * @version 1.0
 * @since 2022/6/28 15:49
 */

public class CglibProxyDemo {
    @Test
    public void test() {
        Enhancer enhancer = new Enhancer();
        //继承被代理类
        enhancer.setSuperclass(ServerImpl.class);
        //设置回调
        enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {
            System.out.println("CglibMethodInterceptor---代理之前");
            return proxy.invokeSuper(obj, args);
        });
        //创建代理对象
        ServerImpl server = (ServerImpl) enhancer.create();
        server.send();
    }


    /**
     * 代理
     */
    class CglibMethodInterceptor implements MethodInterceptor {
        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            System.out.println("CglibMethodInterceptor---代理之前");
            return proxy.invokeSuper(obj, args);

        }
    }
}
