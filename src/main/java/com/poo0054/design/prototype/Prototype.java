package com.poo0054.design.prototype;

import lombok.Data;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href= 'http://c.biancheng.net/view/1338.html'>参考</a>
 * <br/>原型模式 ：用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型相同或相似的新对象。
 * <br/>原型模式包含以下主要角色。
 * <br/>1. 抽象原型类：规定了具体原型对象必须实现的接口。
 * <br/>2. 具体原型类：实现抽象原型类的 clone() 方法，它是可被复制的对象。
 * <br/>3. 访问类：使用具体原型类中的 clone() 方法来复制新的对象。
 *
 * @author zhangzhi
 * @version 1.0
 * @since 2022/6/28 15:11
 */
public class Prototype {

    /**
     * 浅拷贝测试
     */
    @Test
    public void cloneTest() throws CloneNotSupportedException {
        PrototypeObject object = new PrototypeObject();
        object.setName("张三1111");
        object.setStringList(new ArrayList<>(Arrays.asList("asd", "asd")));
        System.out.println("prototypeObject----------" + object);

        PrototypeObject clone = object.clone();
        System.out.println("clone----------" + clone);
        clone.setName("我是改变");
        List<String> stringList = object.getStringList();
        stringList.add("我是新增的");
        System.out.println("clone----------" + clone);
        System.out.println("prototypeObject----------" + object);

        /*
        prototypeObject----------Prototype.PrototypeObject(name=张三1111, stringList=[asd, asd])
        clone----------Prototype.PrototypeObject(name=张三1111, stringList=[asd, asd])
        clone----------Prototype.PrototypeObject(name=我是改变, stringList=[asd, asd, 我是新增的])
        prototypeObject----------Prototype.PrototypeObject(name=张三1111, stringList=[asd, asd, 我是新增的])
        证明是浅拷贝
         */
    }

    /**
     * 浅拷贝测试
     */
    @Test
    public void deepCopyTest() throws IOException, ClassNotFoundException {
        PrototypeObject object = new PrototypeObject();
        object.setName("张三1111");
        object.setStringList(new ArrayList<>(Arrays.asList("asd", "asd")));
        System.out.println("prototypeObject----------" + object);

        PrototypeObject clone = object.deepCopy();
        System.out.println("clone----------" + clone);
        clone.setName("我是改变");
        List<String> stringList = object.getStringList();
        stringList.add("我是新增的");

        System.out.println("clone----------" + clone);
        System.out.println("prototypeObject----------" + object);

        /*
        prototypeObject----------Prototype.PrototypeObject(name=张三1111, stringList=[asd, asd])
        clone----------Prototype.PrototypeObject(name=张三1111, stringList=[asd, asd])
        clone----------Prototype.PrototypeObject(name=我是改变, stringList=[asd, asd])
        prototypeObject----------Prototype.PrototypeObject(name=张三1111, stringList=[asd, asd, 我是新增的])
        证明是深拷贝
         */


    }

    /**
     * 原型模式，实现cloneable
     */
    @Data
    static class PrototypeObject implements Cloneable, Serializable {

        private String name;

        private List<String> stringList;


        public PrototypeObject() {

        }

        @Override
        public PrototypeObject clone() throws CloneNotSupportedException {
            return (PrototypeObject) super.clone();
        }

        /**
         * 深拷贝
         */
        public PrototypeObject deepCopy() throws IOException, ClassNotFoundException {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(this);
            byte[] bytes = outputStream.toByteArray();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return (PrototypeObject) objectInputStream.readObject();
        }
    }
}
