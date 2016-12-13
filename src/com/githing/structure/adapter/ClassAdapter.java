package com.githing.structure.adapter;

/**
 * Created by qile on 16-12-13.
 * 类对象适配器方式(继承的方式)
 * 通过继承KeyBoard来与KeyBoard产生关联
 * 这种方式采用了继承,不够灵活
 */
public class ClassAdapter extends KeyBoard implements Target {

    @Override
    public void handleRequest() {
        //调用KeyBoard的coding方法
        super.coding();
    }
}
