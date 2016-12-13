package com.githing.create.builder;

import com.githing.create.builder.bean.AirShip;

/**
 * Created by qile on 16-12-13.
 * 飞船的组装者接口,用于组装构建者提供的零件
 * 具体如何组装,怎么个组装顺序通过该接口实现类去实现
 */
public interface AirShipDirector {

    //组装飞船
    AirShip createAirShip();

}
