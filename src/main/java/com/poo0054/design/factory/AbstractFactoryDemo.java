package com.poo0054.design.factory;

import org.junit.Test;

/**
 * <a href= 'http://c.biancheng.net/view/1351.html'>参考</a>
 * 抽象工厂：在工厂方法上，再次进行抽象，一个工厂可能存在多种产品
 * ps：抽象工厂模式是工厂方法模式的升级版本，工厂方法模式只生产多种产品，而抽象工厂模式可生产多种产品。  当产品只有一种，退化成工厂方法
 * <br/> ------------------------------
 * <br/>工厂方法模式的主要角色如下。
 * <br/>1. 抽象工厂（AbstractFactory）：提供创建工厂的方法
 * <br/>2. 具体工厂（Factory）：实现自己创建工厂的方法，可以有很多种
 * <br/>3. 抽象产品（AbstractProduct）：定义了产品的规范，描述了产品的主要特性和功能。
 * <br/>4. 产品（Product）：实现了抽象产品角色所定义的接口，由具体工厂来创建，它同具体工厂之间一一对应。
 *
 * @author zhangzhi
 * @version 1.0
 * @since 2022/6/28 11:41
 */

public class AbstractFactoryDemo {

    @Test
    public void test() {
        AnimalFactory animalFactory = new AnimalFactory();
        animalFactory.getProduct().getProduct();
        animalFactory.getProduct1().getProduct();
    }


    /**
     * 抽象工厂
     */
    interface Factory<T> {
        T getProduct();

        T getProduct1();
    }

    /**
     * 抽象工厂，返回产品
     */
    class AnimalFactory implements Factory<AbstractProduct> {
        public AbstractProduct getProduct() {
            return new AnimalProduct();
        }

        @Override
        public AbstractProduct getProduct1() {
            return new BotanyProduct();
        }
    }

    /**
     * 抽象产品
     */
    interface AbstractProduct {
        /**
         * 子类创建不同的方法即可
         */
        void getProduct();
    }

    /**
     * 动物产品
     */
    class AnimalProduct implements AbstractProduct {
        @Override
        public void getProduct() {
            System.out.println("我是一种动物");
        }
    }

    /**
     * 动物产品
     */
    class BotanyProduct implements AbstractProduct {
        @Override
        public void getProduct() {
            System.out.println("我是一种植物");
        }
    }

}


