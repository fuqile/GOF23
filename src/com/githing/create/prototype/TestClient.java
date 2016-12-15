package com.githing.create.prototype;

import java.io.*;
import java.util.Date;

/**
 * Created by qile on 16-12-13.
 * 客户端测试类
 */
public class TestClient {

    public static void main(String[] args) {
        TestClient client = new TestClient();
        client.deepCopy();
        client.shallowCopy();
        client.deSerialization();
        client.testPerformance();
    }

    /**
     * 克隆
     * 深复制
     * 原对象和克隆对象的值的引用不是同一个,已经完全复制一份
     */
    public void deepCopy() {
        Date date = new Date(1234568213L);
        DeepSheep s = new DeepSheep("多利", date);
        System.out.println(s.toString());
        try {
            //克隆s对象
            DeepSheep s2 = (DeepSheep) s.clone();
            System.out.println(s2.toString());
            //克隆后更改date的值,不会导致复制出来的对象的date值也发生变化
            date.setTime(1231321654212L);
            System.out.println(s2.toString());
            //更改克隆出来的对象的值
            s2.setName("克隆多利");
            System.out.println(s2.toString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 克隆
     * 浅复制
     * 原对象和克隆对象值的引用为同一个
     */
    public void shallowCopy() {
        Date date = new Date(1234568213L);
        ShallowSheep s = new ShallowSheep("多利", date);
        System.out.println(s.toString());
        //noinspection Duplicates
        try {
            //克隆s对象
            ShallowSheep s2 = (ShallowSheep) s.clone();
            System.out.println(s2.toString());
            //克隆后更改date的值,会导致复制出来的对象的date值也发生变化
            date.setTime(1231321654212L);
            System.out.println(s2.toString());
            //更改克隆出来的对象的值
            s2.setName("克隆多利");
            System.out.println(s2.toString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用反序列化的方式实现深复制
     * 无需在Bean中使用深复制
     */
    public void deSerialization() {
        Date date = new Date(1234568213L);
        ShallowSheep s = new ShallowSheep("多利", date);
        System.out.println(s.toString());
        //noinspection Duplicates
        try {
            //克隆s对象
            ShallowSheep s2 = (ShallowSheep) s.clone();
            System.out.println(s2.toString());
            //序列化
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(s);
            byte[] bytes = bos.toByteArray();
            //反序列化
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bis);
            ShallowSheep shallowSheep = (ShallowSheep) ois.readObject();

            //反序列化后更改date的值,不会导致复制出来的对象的date值发生变化
            date.setTime(1231321654212L);
            System.out.println(shallowSheep.toString());
            //更改克隆出来的对象的值
            shallowSheep.setName("克隆多利");
            System.out.println(shallowSheep.toString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 测试各种创建对象的性能测试
     */
    public void testPerformance() {
        testClone(100000);
        testNew(100000);
    }

    /**
     * 测试new对象所需的时间
     *
     * @param size
     */
    private void testNew(int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            ShallowSheep shallowSheep = new ShallowSheep();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("bridge 耗时: " + (endTime - startTime));
    }

    /**
     * 测试克隆对象所需的时间
     *
     * @param size
     */
    private void testClone(int size) {
        long startTime = System.currentTimeMillis();
        ShallowSheep shallowSheep = new ShallowSheep();
        for (int j = 0; j < size; j++) {
            try {
                shallowSheep.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("clone 耗时: " + (endTime - startTime));
    }

}
