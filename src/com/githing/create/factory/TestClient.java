package com.githing.create.factory;

import com.githing.create.factory.abstractFactory.Engine;
import com.githing.create.factory.abstractFactory.HignCarFactory;
import com.githing.create.factory.abstractFactory.LowCarFactory;
import com.githing.create.factory.abstractFactory.Seat;
import com.githing.create.factory.factoryMethod.AodiFactoryMethod;
import com.githing.create.factory.factoryMethod.BaomaFactoryMethod;
import com.githing.create.factory.simpleFactory.SimpleCarFactory;

/**
 * Created by qile on 16-12-13.
 */
public class TestClient {
    public static void main(String[] args) {
        TestClient client = new TestClient();
        client.noFactory();
        client.simpleFactory();
        client.factoryMethod();
        client.abstractFactory();
    }

    /**
     * 没有工厂模式下的创建对象
     * client 依赖奥迪 依赖宝马 依赖Car接口
     */
    public void noFactory() {
        Car car1 = new Audi();
        Car car2 = new Baoma();
        car1.run();
        car2.run();
    }

    /**
     * 简单工厂模式创建对象
     * client 只依赖CarFactory和Car
     * 由SimpleCarFactory去依赖aodi baoma car
     */
    public void simpleFactory() {
        //第一种方式
        Car aodi = SimpleCarFactory.createCar("奥迪");
        Car baoma = SimpleCarFactory.createCar("宝马");
        if (aodi != null) {
            aodi.run();
        }
        if (baoma != null) {
            baoma.run();
        }
        //第二种方式
        Car car1 = SimpleCarFactory.createAudi();
        Car car2 = SimpleCarFactory.createBaoma();
        car1.run();
        car2.run();
    }


    /**
     * 工厂方法模式创建对象
     */
    public void factoryMethod() {
        Car aodi = new AodiFactoryMethod().createCar();
        Car baoma = new BaomaFactoryMethod().createCar();
        aodi.run();
        baoma.run();
    }

    /**
     * 抽象工厂模式创建
     */
    public void abstractFactory() {
        //通过高端工厂创建一个高端发动机
        Engine hignEngine = new HignCarFactory().createEngine();
        hignEngine.start();
        //通过低端工厂创建一个低端座位
        Seat seat = new LowCarFactory().createSeat();
        seat.sit();
    }
}
