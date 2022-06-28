package com.poo0054.design.proxy.cglibproxy;

/**
 * cglib代理创建类 需要公开的方法
 * 目标方法
 *
 * @author zhangzhi
 * @version 1.0
 * @since 2022/6/28 17:14
 */

public class ServerImpl {


    public void send() {
        System.out.println("我来发送消息了");
    }
}
