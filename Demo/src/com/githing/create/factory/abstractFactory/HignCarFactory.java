package com.githing.create.factory.abstractFactory;

/**
 * Created by qile on 16-12-13.
 * 高端工厂实现类,创建高端零件,包括高端发动机,高端座椅...可扩展产品族
 */
public class HignCarFactory implements CarAbstractFactory {
    @Override
    public Engine createEngine() {
        return new HignEngine();
    }

    @Override
    public Seat createSeat() {
        return new HignSeat();
    }
}
