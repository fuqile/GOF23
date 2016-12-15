package com.githing.structure.bridge.bridge;

/**
 * Created by qile on 16-12-14.
 * 由于不加public修饰符的class无法在包外访问,故将TestClient放在包内
 */
public class TestClient {

    public static void main(String[] args) {

        //将联想品牌和台式机进行组合
        //使用类的组合来代替继承关系
        BridgeComputer computer = new Desktop(new Lenove());
        computer.sale();

    }

}
