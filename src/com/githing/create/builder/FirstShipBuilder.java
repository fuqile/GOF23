package com.githing.create.builder;

import com.githing.create.builder.bean.Engine;
import com.githing.create.builder.bean.EscapeTower;
import com.githing.create.builder.bean.OrbitalModule;

/**
 * Created by qile on 16-12-13.
 * 飞船构建者的实现类,具体是如何构建
 * 此处可以结合工厂创建模式构建单独的对象
 */
public class FirstShipBuilder implements AirShipBuilder {

    @Override
    public Engine builderEngine() {
        System.out.println("第一个发动机");
        //此处可以结合工厂模式创建对象
        return new Engine("第一个发动机");
    }

    @Override
    public OrbitalModule builderOrbitalModule() {
        System.out.println("第一个轨道舱");
        return new OrbitalModule("第一个轨道舱");
    }

    @Override
    public EscapeTower builderEscapeTower() {
        System.out.println("第一个逃逸舱");
        return new EscapeTower("第一个逃逸舱");
    }
}
