package com.githing.create.factory.simpleFactory;

import com.githing.create.factory.Audi;
import com.githing.create.factory.Baoma;
import com.githing.create.factory.Car;

/**
 * Created by qile on 16-12-13.
 * 简单工厂模式,也称为静态工厂模式,就是工厂类一般是使用的静态方法
 * 违反开闭原则(OCP),增加类型扩展需要修改代码
 */
public class SimpleCarFactory {
    public static Car createCar(String type) {
        if ("奥迪".equals(type)) {
            return new Audi();
        } else if ("宝马".equals(type)) {
            return new Baoma();
        } else {
            return null;
        }
    }

    /**
     * 和上面方式不同的另一种创建模式
     * @return
     */
    public static Car createAudi(){
        return new Audi();
    }

    public static Car createBaoma(){
        return new Baoma();
    }
}
