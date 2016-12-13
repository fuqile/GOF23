package com.githing.create.singleton;

/**
 * Created by qile on 16-12-12.
 * 静态内部类实现方式
 * 这种方式线程安全,调用效率高,并且实现了延时加载(lazy load)
 * 优势明显,被很多框架采用
 */
public class SingletonStaticInnerClass {

    private static class SingletonClassInstance {
        //使用static final修饰保证内存中只有一个实例存在
        private static final SingletonStaticInnerClass instance = new SingletonStaticInnerClass();
    }

    //只有调用getIntance时候才会加载静态内部类,类加载线程安全
    public static SingletonStaticInnerClass getInstance() {
        return SingletonClassInstance.instance;
    }

}
