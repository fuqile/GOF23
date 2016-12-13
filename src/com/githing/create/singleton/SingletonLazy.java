package com.githing.create.singleton;

import java.io.Serializable;

/**
 * Created by qile on 16-12-12.
 * 懒汉式加载
 * 延时加载,要用的时候在加载
 */
public class SingletonLazy implements Serializable {

    private static SingletonLazy instance;

    //私有化构造器
    private SingletonLazy() {
        //防止通过反射创建多个实例
        if (instance != null) {
            throw new RuntimeException("instance already exist!");
        }
    }

    //防止反序列化时创建多个实例
    //执行反序列化的时候会自动调用这个方法
    private Object readResolve() {
        return instance;
    }

    //需要加入synchronized关键字,同步,防止并发量大的时候创建多个instance
    //方法同步,效率低
    public static synchronized SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }


}
