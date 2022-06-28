package com.poo0054.design.singleton;

import org.junit.Test;

/**
 * <a href= 'http://c.biancheng.net/view/1338.html'>参考</a>
 * <br/>单例模式：单例模式可以保证在一个 JVM 中只存在单一实例
 * <br/>单例模式的主要角色如下。
 * <br/>1. 单例类：包含一个实例且能自行创建这个实例的类。
 * <br/>2. 访问类：使用单例的类。
 *
 * @author zhangzhi
 * @version 1.0
 * @since 2022/6/28 14:54
 */

public class SingletonDemo {

    @Test
    public void test() {
        DoubleCheckLazySinglet lazySinglet = DoubleCheckLazySinglet.getLazySinglet();

    }

    //===========================懒汉式

    /**
     * 懒汉式单例，使用双重检查锁定
     */
    static class DoubleCheckLazySinglet {
        private static volatile DoubleCheckLazySinglet lazySinglet = null;

        /**
         * 单例模式最重要的一点，私有化构造器
         */
        private DoubleCheckLazySinglet() {

        }

        /**
         * 使用双重检查锁定，volatile保证内存可见
         *
         * @return 单例对象
         */
        public static DoubleCheckLazySinglet getLazySinglet() {
            if (lazySinglet == null) {
                synchronized (lazySinglet) {
                    if (null == lazySinglet) {
                        lazySinglet = new DoubleCheckLazySinglet();
                    }
                }
            }
            return lazySinglet;
        }
    }

    /**
     * 使用内部类单例
     */
    static class InnerClassLazySinglet {
        private InnerClassLazySinglet() {
        }


        public static class InnerClass {
            private static final InnerClassLazySinglet lazySinglet = new InnerClassLazySinglet();
        }

        /**
         * 使用类加载的时候是线程安全的机制，只有在调用时，才会加载实现懒加载
         *
         * @return 单例对象
         */
        public static InnerClassLazySinglet getInstance() {
            return InnerClass.lazySinglet;
        }
    }


    //===================================饿汉式

    /**
     * 饿汉式
     */
    static class HungrySinglet {
        private static final HungrySinglet lazySinglet = new HungrySinglet();

        private HungrySinglet() {
        }

        public static HungrySinglet getInstance() {
            return lazySinglet;
        }

    }


}
