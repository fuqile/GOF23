package com.githing.create.factory.abstractFactory;

/**
 * Created by qile on 16-12-13.
 * 座位接口,提供一些座位共有属性方法
 * 高端低端座位实现该接口即可
 */
public interface Seat {
    void sit();
}

/**
 * 低端座椅
 */
class LowSeat implements Seat {

    @Override
    public void sit() {
        System.out.println("低端,坐上去不舒服");
    }
}

/**
 * 高端座椅
 */
class HignSeat implements Seat {

    @Override
    public void sit() {
        System.out.println("高端,坐上去舒服");
    }
}
