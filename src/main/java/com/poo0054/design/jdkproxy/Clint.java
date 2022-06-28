package com.poo0054.design.jdkproxy;

public class Clint {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(new ServiceImpl());
        IService instance = (IService) proxyFactory.instance();
        instance.add(1);
    }

}
