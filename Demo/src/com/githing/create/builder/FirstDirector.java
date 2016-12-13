package com.githing.create.builder;

import com.githing.create.builder.bean.AirShip;
import com.githing.create.builder.bean.Engine;
import com.githing.create.builder.bean.EscapeTower;
import com.githing.create.builder.bean.OrbitalModule;

/**
 * Created by qile on 16-12-13.
 * 组装者的具体实现类
 * 具体如何组装,组装哪几个,组装顺序由该类实现
 */
public class FirstDirector implements AirShipDirector {

    private AirShipBuilder builder;

    public FirstDirector(AirShipBuilder builder) {
        this.builder = builder;
    }

    /**
     * 具体实现如何创建飞船
     * @return
     */
    @Override
    public AirShip createAirShip() {
        //通过构建者创建各个零件
        Engine engine = builder.builderEngine();
        OrbitalModule orbitalModule = builder.builderOrbitalModule();
        EscapeTower escapeTower = builder.builderEscapeTower();
        //组装成一个AirShip飞船
        AirShip airShip = new AirShip();
        airShip.setEngine(engine);
        airShip.setEscapeTower(escapeTower);
        airShip.setOrbitalModule(orbitalModule);
        //返回组装好的飞船
        return airShip;
    }
}
