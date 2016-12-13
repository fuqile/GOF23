package com.githing.create.factory.factoryMethod;

import com.githing.create.factory.Car;

/**
 * Created by qile on 16-12-13.
 * 工厂方法模式创建对象
 * 新增类型扩展只需要实现CarFactoryMethod接口即可,满足OCP开闭原则
 * 缺点:扩展需要创建很多类,变得复杂
 * 根据设计理论建议,工厂方法模式占优,但是实际上我们一般都使用简单工厂模式
 */
public interface CarFactoryMethod {
    Car createCar();
}
