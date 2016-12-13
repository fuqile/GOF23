package com.githing.create.prototype;

import java.util.Date;

/**
 * Created by qile on 16-12-13.
 * <p>
 * 原型模式,克隆模式(深复制),原先的引用也会复制一份,不会引用原对象的其他引用
 * <p>
 * 1997年克隆羊 Sheep
 * 克隆羊实例对象
 * 需要克隆对象必须要实现Cloneable接口
 * Cloneable接口是个标记接口(空接口)
 * clone方法是Object中的方法,native实现,效率高
 */
public class DeepSheep implements Cloneable {

    private String name;
    private Date birthday;

    public DeepSheep(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //获取克隆出来的对象并强转
        Object object = super.clone();
        DeepSheep sheep = (DeepSheep) object;
        //对属性进行克隆
        //这样在复制的时候就会重新复制一份,不会和原对象引用同一个值
        //比如原对象引用的date值更改后不会对克隆出来的对象造成影响
        sheep.birthday = (Date) this.birthday.clone();
        return sheep;
    }
}
