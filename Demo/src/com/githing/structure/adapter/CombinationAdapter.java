package com.githing.structure.adapter;

/**
 * Created by qile on 16-12-13.
 * 对象组合适配器方式
 * 不需要继承键盘,以对象组合的形式通过构造器传入Keyboard对象
 */
public class CombinationAdapter implements Target {

    private KeyBoard keyBoard;

    public CombinationAdapter(KeyBoard keyBoard) {
        this.keyBoard = keyBoard;
    }

    @Override
    public void handleRequest() {
        //调用keyBoard的coding方法
        keyBoard.coding();
    }
}
