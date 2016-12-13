package com.githing.create.builder.bean;

/**
 * Created by qile on 16-12-13.
 * 飞船实例对象
 * 轨道舱,发动机,逃逸舱可以看成是创建一个飞船所需的组件
 */
public class AirShip {
    //轨道仓
    private OrbitalModule orbitalModule;
    //发动机
    private Engine engine;
    //逃逸舱
    private EscapeTower escapeTower;

    //创建一个飞船的行为方法
    public void launch() {
        System.out.println("飞船启动");
    }


    public OrbitalModule getOrbitalModule() {
        return orbitalModule;
    }

    public void setOrbitalModule(OrbitalModule orbitalModule) {
        this.orbitalModule = orbitalModule;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public EscapeTower getEscapeTower() {
        return escapeTower;
    }

    public void setEscapeTower(EscapeTower escapeTower) {
        this.escapeTower = escapeTower;
    }
}
