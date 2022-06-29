package com.poo0054.design.adapter;

import lombok.Data;
import org.junit.Test;

/**
 * <a href= 'http://c.biancheng.net/view/1361.html'>参考</a>
 * <br/> 适配器模式：将一个类的接口转换成客户希望的另外一个接口，使得原本由于接口不兼容而不能一起工作的那些类能一起工作。
 * <br/>适配器模式分为类结构型模式和对象结构型模式两种，前者类之间的耦合度比后者高，且要求程序员了解现有组件库中的相关组件的内部结构，所以应用相对较少些。
 * <br/>适配器模式（Adapter）包含以下主要角色。
 * <br/>1. 目标（Target）接口：当前系统业务所期待的接口，它可以是抽象类或接口。
 * <br/>2. 适配者（Adaptee）类：它是被访问和适配的现存组件库中的组件接口。
 * <br/>3. 适配器（Adapter）类：它是一个转换器，通过继承或引用适配者的对象，把适配者接口转换成目标接口，让客户按目标接口的格式访问适配者。
 *
 * @author zhangzhi
 * @version 1.0
 * @since 2022/6/28 17:19
 */
public class AdapterDemo {
    @Test
    public void classAdapterTest() {
        //调用自己的
        Service service = new ServiceImpl();
        service.send();
        //调用适配后的
        Service adapter = new ClassAdapter();
        adapter.send();
        //这样就可以实现不同的方法和类 在一起用超类Service管理
    }

    @Test
    public void objectAdapterTest() {
        //调用自己的
        Service service = new ServiceImpl();
        service.send();
        //调用适配后的
        Service adapter = new ObjectAdapter(new Adaptee());

        adapter.send();
        //这样就可以实现不同的方法和类 在一起用超类Service管理
    }

    /**
     * 目标
     */
    interface Service {
        public void send();
    }

    /**
     * 服务实现（目标实现）
     */
    class ServiceImpl implements Service {
        @Override
        public void send() {
            System.out.println("我在发消息---send");
        }
    }

    /**
     * 适配者
     */
    class Adaptee {
        public void sending() {
            System.out.println("发送---sending");
        }
    }

    //============================对象适配器

    /**
     * 类适配器。
     * 表面看调用的send，其实是调用的sending。使用Service接口 就能够统一了
     */
    class ClassAdapter extends Adaptee implements Service {
        @Override
        public void send() {
            sending();
        }
    }

    //============================对象适配器

    /**
     * 对象适配器，
     * 使用组合的关系，耦合性比类的低，随时可以替换适配对象
     */
    @Data
    class ObjectAdapter implements Service {

        private Adaptee adaptee;

        public ObjectAdapter(Adaptee adaptee) {
            this.adaptee = adaptee;
        }

        @Override
        public void send() {
            adaptee.sending();
        }
    }


}
