package com.githing.create.singleton;

/**
 * Created by qile on 16-12-12.
 * 饿汉式单例模式
 * 特点,
 * 线程安全,使用类加载天然线程安全
 * 不需要添加synchronized,效率高
 */
public class SingletonHungry {

    //类初始化的时候立刻加载这个类
    private static SingletonHungry instance = new SingletonHungry();

    //私有构造器
    private SingletonHungry() {

    }

    //对外只提供getInstance方法
    public static SingletonHungry getInstance() {
        return instance;
    }

}
