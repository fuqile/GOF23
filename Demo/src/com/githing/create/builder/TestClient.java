package com.githing.create.builder;

import com.githing.create.builder.bean.AirShip;

/**
 * Created by qile on 16-12-13.
 * 客户端测试类
 */
public class TestClient {

    public static void main(String[] args) {
        //new 一个组装者,需要传入一个构建者
        AirShipDirector director = new FirstDirector(new FirstShipBuilder());
        //通过组装者组装一个AirShip飞船
        AirShip airShip = director.createAirShip();
        //调用飞船的行为方法
        airShip.launch();
    }


}
