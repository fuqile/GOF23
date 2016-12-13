package com.githing.create.factory.factoryMethod;

import com.githing.create.factory.Baoma;
import com.githing.create.factory.Car;

/**
 * Created by qile on 16-12-13.
 */
public class BaomaFactoryMethod implements CarFactoryMethod {
    @Override
    public Car createCar() {
        return new Baoma();
    }
}
