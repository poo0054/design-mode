package com.poo0054.design.bulider;

import lombok.Data;
import lombok.ToString;
import org.junit.Test;

/**
 * <a href= 'http://c.biancheng.net/view/1354.html'>参考</a>
 * <br/>建造者模式 ： 指将一个复杂对象的构造与它的表示分离，使同样的构建过程可以创建不同的表示，这样的设计模式被称为建造者模式。
 * <br/>ps：建造者（Builder）模式和工厂模式的关注点不同：建造者模式注重零部件的组装过程，而工厂方法模式更注重零部件的创建过程，但两者可以结合使用。
 * <br/>建造者（Builder）模式的主要角色如下。
 * <br/>1. 产品角色（Product）：它是包含多个组成部件的复杂对象，由具体建造者来创建其各个零部件。
 * <br/>2. 抽象建造者（AbstractBuilder）：它是一个包含创建产品各个子部件的抽象方法的接口，通常还包含一个返回复杂产品的方法 getResult()。
 * <br/>3. 具体建造者(Concrete Builder）：实现 Builder 接口，完成复杂产品的各个部件的具体创建方法。
 * <br/>4. 指挥者（Director）：它调用建造者对象中的部件构造与装配方法完成复杂对象的创建，在指挥者中不涉及具体产品的信息。
 *
 * @author zhangzhi
 * @version 1.0
 * @since 2022/6/28 14:15
 */
public class builderDemo {

    @Test
    public void test() {
        Director<Computer> director = new Director(new Builder2());
        Computer build = director.build();
        System.out.println(build.toString());
    }

    /**
     * 产品角色（Product）：它是包含多个组成部件的复杂对象
     * <br/>电脑需要的部件，但是每个部件都可以用不同的牌子
     */
    @Data
    @ToString
    class Computer {
        /**
         * 显示器
         */
        private String monitor;
        /**
         * 主机
         */
        private String host;
        /**
         * 键盘
         */
        private String keyboard;
        /**
         * 鼠标
         */
        private String mouse;
    }

    /**
     * 抽象建造者：存在不同的建造者，不同类实现即可
     */
    interface abstractBuilder<T> {
        /**
         * 构建显示器
         */
        void monitor();

        /**
         * 构建主机
         */
        void host();

        /**
         * 构建键盘
         */
        void keyboard();

        /**
         * 构建鼠标
         */
        void mouse();

        /**
         * 构建结果
         *
         * @return 返回组装好的电脑
         */
        T result();
    }

    /**
     * 具体的产品构建者，用来构建具体产品
     */
    @Data
    class Builder1 implements abstractBuilder<Computer> {

        private Computer computer = new Computer();

        @Override
        public void monitor() {
            computer.setMonitor("显示器安装完成 -- 小米显示器");
        }

        @Override
        public void host() {
            computer.setHost("主机安装完成 ---- 外星人（灯光炫酷）");
        }

        @Override
        public void keyboard() {
            computer.setKeyboard("键盘安装完成  --- 雷神鼠标 ");
        }

        @Override
        public void mouse() {
            computer.setMouse("鼠标安装完成 --- 雷神键盘");
        }

        @Override
        public Computer result() {
            return computer;
        }
    }

    /**
     * 具体的产品构建者，用来构建具体产品
     */
    @Data
    class Builder2 implements abstractBuilder<Computer> {

        private Computer computer = new Computer();

        @Override
        public void monitor() {
            computer.setMonitor("显示器安装完成 -- aoc显示器 ");
        }

        @Override
        public void host() {
            computer.setHost("主机安装完成 ---- 苹果主机 ");
        }

        @Override
        public void keyboard() {
            computer.setKeyboard("键盘安装完成  --- 雷神鼠标 ");
        }

        @Override
        public void mouse() {
            computer.setMouse("鼠标安装完成 --- 雷神键盘");
        }

        @Override
        public Computer result() {
            return computer;
        }
    }

    /**
     * 指挥者：它调用建造者对象中的部件构造与装配方法完成复杂对象的创建
     */
    class Director<T> {
        private final abstractBuilder<T> abstractBuilder;

        public Director(abstractBuilder<T> abstractBuilder) {
            this.abstractBuilder = abstractBuilder;
        }

        public T build() {
            abstractBuilder.monitor();
            abstractBuilder.host();
            abstractBuilder.keyboard();
            abstractBuilder.mouse();
            return abstractBuilder.result();
        }
    }

}
