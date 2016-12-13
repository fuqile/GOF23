package com.githing.create.singleton;

/**
 * Created by qile on 16-12-12.
 * 使用枚举实现单例模式
 * <p>
 * 优点:
 * 实现简单,枚举天然就是单例模式,有JVM从根本上提供保障
 * 避免通过反射和反序列化漏洞
 * 缺点:
 * 无延迟加载
 */
public enum SingletonEnum {

    //定义一个枚举的元素,就代表了一个SingletonEnum实例
    INSTANCE;

    //单例也可以有自己的操作
    public void singletonOperation() {
        //操作处理
    }

}
