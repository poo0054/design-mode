package com.poo0054.design.factory;

import org.junit.Test;

/**
 * <a href= 'http://c.biancheng.net/view/1348.html'>参考</a>
 * <br/>工厂方法模式： 工厂方法模式是对简单工厂模式的进一步抽象化，使用不同工厂创建不同产品。
 * 工厂方法模式中考虑的是一类产品的生产，如畜牧场只养动物、电视机厂只生产电视机、计算机软件学院只培养计算机软件专业的学生等。
 * <br/>ps：删除抽象工厂 只用一个工厂方法创建产品 就退化到简单工厂 （静态工厂方法模式）。
 * 抽象工厂模式可生产多种产品。  当产品只有一种，退化成工厂方法
 * <br/>工厂方法模式的主要角色如下。
 * <br/>1. 抽象工厂（AbstractFactory）：提供创建工厂的方法
 * <br/>2. 具体工厂（Factory）：实现自己创建工厂的方法，可以有很多种
 * <br/>3. 抽象产品（AbstractProduct）：定义了产品的规范，描述了产品的主要特性和功能。
 * <br/>4. 产品（Product）：实现了抽象产品角色所定义的接口，由具体工厂来创建，它同具体工厂之间一一对应。
 *
 * @author zhangzhi
 * @version 1.0
 * @since 2022/6/28 10:49
 */
public class FactoryMethodDome {

    /**
     * <br/>根据不同的productName，生产出不同的产品。
     * <br/>扩展：如果又有新需求 想要一个不是AbstractProduct类型抽象产品。
     * <br/>  1. 只需要实现AbstractFactory，自定义一个工厂实现类
     * <br/>  2.  定义一个不同的AbstractProduct抽象产品
     * <br/>  3. 实现自定义的抽象产品，实现具体的产品
     * <br/>  4. 在自定义的工厂方法根据不同条件实现不同的具体产品
     * <br/>ps:如果我想动物中某一个具体的种类，可以直接把动物写成抽象类，植物也是一种抽象类，然后使用具体的类-》狼继承抽象类（动物）即可
     */
    @Test
    public void test() {
        AbstractFactory<AbstractProduct> animalFactory = new AnimalFactory();
        AbstractProduct animal = animalFactory.getProduct();
        animal.getProduct();
        //--------------------------
        AbstractFactory<AbstractProduct> botanyFactory = new BotanyFactory();
        botanyFactory.getProduct().getProduct();
    }


    /**
     * 抽象工厂，定义工厂的规范
     */
    interface AbstractFactory<T> {

        /**
         * 返回产品，根据name创建不同的产品，不同的工厂会造成产品的不同
         *
         * @return 返回具体产品
         */
        T getProduct();
    }

    /**
     * 具体工厂，用来生产产品
     */
    class AnimalFactory implements AbstractFactory<AbstractProduct> {
        public AbstractProduct getProduct() {
            return new AnimalProduct();
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
     * 具体工厂，用来生产产品
     */
    class BotanyFactory implements AbstractFactory<AbstractProduct> {
        public AbstractProduct getProduct() {
            return new BotanyProduct();
        }
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
     * 植物产品
     */
    class BotanyProduct implements AbstractProduct {
        @Override
        public void getProduct() {
            System.out.println("我是一种植物");
        }
    }
}