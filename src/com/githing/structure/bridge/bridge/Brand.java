package com.githing.structure.bridge.bridge;

/**
 * Created by qile on 16-12-14.
 * 品牌类型
 * 新加类型和品牌没有关系,只需要添加继承类即可
 * 便于扩展,遵守单一原则
 */
public interface Brand {
    void sale();
}

class Lenove implements Brand {

    @Override
    public void sale() {
        System.out.println("联想");
    }
}

class Asus implements Brand {

    @Override
    public void sale() {
        System.out.println("华硕");
    }
}
