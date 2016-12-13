package com.githing.create.prototype;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by qile on 16-12-13.
 * <p>
 * 原型模式(克隆模式) 浅复制,复制原对象,同时也复制原对象的引用
 * 意味着克隆对象和原对象引用的是同一个值,当值改变的时候克隆的对象也会改变
 * <p>
 * 1997年克隆羊 Sheep
 * 克隆羊实例对象
 * 需要克隆对象必须要实现Cloneable接口
 * Cloneable接口是个标记接口(空接口)
 * clone方法是Object中的方法,native实现,效率高
 */
public class ShallowSheep implements Cloneable, Serializable {

    private String name;
    private Date birthday;

    public ShallowSheep() {
    }

    public ShallowSheep(String name, Date birthday) {
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
        //直接调用object对象的clone方法
        return super.clone();
    }
}
