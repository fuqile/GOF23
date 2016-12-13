package com.githing.create.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by qile on 16-12-12.
 * 测试单例类
 */
public class TestClient {

    public static void main(String[] args) {
        //测试是否是单例结果
        System.out.println(SingletonHungry.getInstance() == SingletonHungry.getInstance());
        System.out.println(SingletonLazy.getInstance() == SingletonLazy.getInstance());
        System.out.println(SingletonStaticInnerClass.getInstance() == SingletonStaticInnerClass.getInstance());
        System.out.println(SingletonDoubleCheckLock.getInstance() == SingletonDoubleCheckLock.getInstance());
        System.out.println(SingletonEnum.INSTANCE == SingletonEnum.INSTANCE);
        TestClient client = new TestClient();
//        client.testReflect();
//        client.testDeSerialization();
        client.testPerformance(1);
        client.testPerformance(2);
        client.testPerformance(3);
        client.testPerformance(4);
        client.testPerformance(5);
    }

    /**
     * 测试通过反射创建多个对象
     * 直接调用私有构造器
     */
    public void testReflect() {
        //这里以测试懒汉式延时加载为例
        try {
            Class<SingletonLazy> clazz = (Class<SingletonLazy>) Class.forName("com.githing.create.singleton.SingletonLazy");
            Constructor<SingletonLazy> constructor = clazz.getDeclaredConstructor(null);
            //跳过检查,true可以调用私有化方法
            constructor.setAccessible(true);
            SingletonLazy s1 = constructor.newInstance();
            SingletonLazy s2 = constructor.newInstance();
            System.out.println(s1 == s2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试反序列化
     */
    public void testDeSerialization() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("/tmp/test.txt");
            oos = new ObjectOutputStream(fos);
            //进行序列化操作
            oos.writeObject(SingletonLazy.getInstance());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //执行反序列化操作
        try {
            FileInputStream fis = new FileInputStream("/tmp/test.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            SingletonLazy s = (SingletonLazy) ois.readObject();
            //判断反序列化出来的对象与原先的单例对象是否是同一个
            System.out.println(SingletonLazy.getInstance() == s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 测试多线程环境下各个单例创建的性能
     */
    public void testPerformance(int type) {

        //记录开始时间
        long startTime = System.currentTimeMillis();
        //定义线程数量
        int threadNumber = 10;
        //同步辅助类,在完成一组正在其他线程中执行的操作之前,他允许一个或多个线程一直等待
        CountDownLatch countDownLatch = new CountDownLatch(threadNumber);

        for (int i = 0; i < threadNumber; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //设定每个线程 get 10万次实例
                    for (int j = 0; j < 100000; j++) {
                        switch (type) {
                            case 1:
                                //测试饿汉式单例时间
                                SingletonHungry.getInstance();
                                break;
                            case 2:
                                //测试懒汉式单例时间
                                SingletonLazy.getInstance();
                                break;
                            case 3:
                                //测试静态内部类式单例时间
                                SingletonStaticInnerClass.getInstance();
                                break;
                            case 4:
                                //测试双重检查锁式单例时间
                                SingletonDoubleCheckLock.getInstance();
                                break;
                            case 5:
                                //测试枚举式单例时间
                                SingletonEnum instance = SingletonEnum.INSTANCE;
                                break;
                        }
                    }
                    //计数器减1,如果有try catch建议放在finally里面
                    countDownLatch.countDown();
                }
            }).start();
        }

        try {
            //main线程阻塞,直到计数器为0,才结束
            countDownLatch.await();
            //记录结束时间
            long endTime = System.currentTimeMillis();
            //输出耗时
            switch (type) {
                case 1:
                    System.out.println("SingletonHungry 耗时:" + (endTime - startTime));
                    break;
                case 2:
                    System.out.println("SingletonLazy 耗时:" + (endTime - startTime));
                    break;
                case 3:
                    System.out.println("SingletonStaticInnerClass 耗时:" + (endTime - startTime));
                    break;
                case 4:
                    System.out.println("SingletonDoubleCheckLock 耗时:" + (endTime - startTime));
                    break;
                case 5:
                    System.out.println("SingletonEnum 耗时:" + (endTime - startTime));
                    break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
