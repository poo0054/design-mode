package com.poo0054.design.bridge;

import org.junit.Test;

/**
 * <a href= 'http://c.biancheng.net/view/1364.html'>参考</a>
 * <br/>桥接模式（Bridge模式）:将抽象与实现分离，使它们可以独立变化。它是用组合关系代替继承关系来实现，从而降低了抽象和实现这两个可变维度的耦合度。
 * <br/>桥接（Bridge）模式包含以下主要角色。
 * <br/>1. 抽象化（Abstraction）角色：定义抽象类，并包含一个对实现化对象的引用。
 * <br/>2. 扩充抽象类（Refined Abstraction）角色：是抽象化角色的子类，实现父类中的业务方法，并通过组合关系调用实现化角色中的业务方法。
 * <br/>3. 实现者（Implementor）角色：定义实现化角色的接口，供扩展抽象化角色调用。
 * <br/>4. 具体实现者（Concrete Implementor）角色：给出实现化角色接口的具体实现。
 *
 * @author zhangzhi
 * @version 1.0
 * @since 2022/6/28 17:39
 */
public class BridgeDemo {

    @Test
    public void test() {
        StapleFoodAbstract stapleFoodAbstract = new Meal();
        stapleFoodAbstract.setFoodImplementor(new Green());

        System.out.println("我点的饭为：" + stapleFoodAbstract.checkout());
        System.out.println("我吃的菜为：" + stapleFoodAbstract.getFoodImplementor().foodCheckout());

    }


    /**
     * 实现 菜只需要关注菜  不需要关注是吃的什么饭。抽象与实现分离
     * 拌饭的菜 或者 拌面的菜
     */
    interface foodImplementor {
        String foodCheckout();
    }

    /**
     * 具体实现者
     * 肉
     */
    class Meat implements foodImplementor {
        @Override
        public String foodCheckout() {
            return "我是肉";
        }
    }

    /**
     * 具体实现者
     * 青菜
     */
    class Green implements foodImplementor {
        @Override
        public String foodCheckout() {
            return "我是青菜";
        }
    }


    /**
     * 抽象化  我只关注我吃什么饭，聚合的方法把菜融合进来。抽象与实现分离
     */
    abstract class StapleFoodAbstract {
        private foodImplementor foodImplementor;

        public void setFoodImplementor(BridgeDemo.foodImplementor foodImplementor) {
            this.foodImplementor = foodImplementor;
        }

        public BridgeDemo.foodImplementor getFoodImplementor() {
            return foodImplementor;
        }

        abstract String checkout();
    }

    /**
     * 具体抽象化
     * 面
     */
    class Noodles extends StapleFoodAbstract {
        @Override
        public String checkout() {
            return "----------我是一碗面";
        }
    }

    /**
     * 具体抽象化
     * 饭
     */
    class Meal extends StapleFoodAbstract {
        @Override
        public String checkout() {
            return "----------我是一碗饭";
        }
    }

}
