package com.githing.structure.bridge.bridge;

/**
 * Created by qile on 16-12-14.
 * <p>
 * 电脑类型结构
 * 新加电脑类型和品牌没有关系,只需要添加继承类即可
 * 便于扩展,遵守单一原则
 */
public class BridgeComputer {

    protected Brand brand;

    public BridgeComputer(Brand brand) {
        this.brand = brand;
    }

    public void sale() {
        brand.sale();
    }
}

class Desktop extends BridgeComputer {

    public Desktop(Brand brand) {
        super(brand);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("销售台式机");
    }
}

class Laptop extends BridgeComputer {

    public Laptop(Brand brand) {
        super(brand);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("销售笔记本电脑");
    }
}