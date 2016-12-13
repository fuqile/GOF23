package com.githing.create.factory.factoryMethod;

import com.githing.create.factory.Audi;
import com.githing.create.factory.Car;

/**
 * Created by qile on 16-12-13.
 */
public class AodiFactoryMethod implements CarFactoryMethod {
    @Override
    public Car createCar() {
        return new Audi();
    }
}
