package com.githing.create.factory.abstractFactory;

/**
 * Created by qile on 16-12-13.
 * 低端工厂实现类,创建低端零件,包括低端发动机,低端座椅...可扩展产品族
 */
public class LowCarFactory implements CarAbstractFactory {
    @Override
    public Engine createEngine() {
        return new LowEngine();
    }

    @Override
    public Seat createSeat() {
        return new LowSeat();
    }
}
