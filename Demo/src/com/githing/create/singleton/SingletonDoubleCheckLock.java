package com.githing.create.singleton;

/**
 * Created by qile on 16-12-12.
 * 双重检查锁实现方式
 * 这个模式将同步内容放到if内部,提高了执行的效率,不必每次获取对象时都进行同步
 * 只有第一次才同步,创建了以后就不需要了
 *
 * problem:
 * 由于编译器优化原因和JVM底层内部模型原因,偶尔会出问题,不建议使用
 */
public class SingletonDoubleCheckLock {

    private static SingletonDoubleCheckLock instance = null;

    public static SingletonDoubleCheckLock getInstance() {
        if (instance == null) {
            SingletonDoubleCheckLock sc;
            synchronized (SingletonDoubleCheckLock.class) {
                sc = instance;
                synchronized (SingletonDoubleCheckLock.class) {
                    if (sc == null) {
                        sc = new SingletonDoubleCheckLock();
                    }
                }
            }
            instance = sc;
        }
        return instance;
    }

}
