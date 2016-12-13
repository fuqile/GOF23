package com.githing.create.builder;

import com.githing.create.builder.bean.Engine;
import com.githing.create.builder.bean.EscapeTower;
import com.githing.create.builder.bean.OrbitalModule;

/**
 * Created by qile on 16-12-13.
 * 飞船构建者接口,用于构建不同零件
 * 具体构建的内容可以通过不同的实现类去实现,例如FirstAirShipBuilder,SecondAirShipBuilder
 */
public interface AirShipBuilder {

    //构建发动机,具体构建高端发动机还是低端发动机由实现类实现
    Engine builderEngine();

    //构建轨道舱
    OrbitalModule builderOrbitalModule();

    //构建逃逸舱
    EscapeTower builderEscapeTower();

}
