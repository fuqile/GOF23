package com.githing.create.factory.abstractFactory;

/**
 * Created by qile on 16-12-13.
 * 发动机接口,提供一些发动机共有属性方法
 * 高端发动机低端发动机实现该接口即可
 */
public interface Engine {
    void start();
}

/**
 * 低端发动机
 */
class LowEngine implements Engine {

    @Override
    public void start() {
        System.out.println("低端发动机启动慢");
    }
}

/**
 * 高端发动机
 */
class HignEngine implements Engine {

    @Override
    public void start() {
        System.out.println("高端发动机启动快");
    }
}
