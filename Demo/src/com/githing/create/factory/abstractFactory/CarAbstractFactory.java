package com.githing.create.factory.abstractFactory;

/**
 * Created by qile on 16-12-13.
 */
public interface CarAbstractFactory {
    Engine createEngine();

    Seat createSeat();
}
