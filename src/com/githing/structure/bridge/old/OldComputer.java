package com.githing.structure.bridge.old;

/**
 * Created by qile on 16-12-14.
 * 传统模式(不使用桥接模式)
 * 电脑接口
 * 提供sale销售方法
 * 该品牌扩展为 多层继承结构   ,不利于扩展
 * 如果要增加一个新的Computer类型(假设要增加Mobile),则要增加各个品牌下面的类
 * 如果要增加一个新的品牌,也要增加各种电脑类型的类
 * <p>
 * 违反单一职责原则
 * 一个类:联想笔记本,会有两个引起这个类变化的原因
 * 第一个,品牌:联想
 * 第二个,类型:笔记本
 */
public interface OldComputer {
    //销售方法
    void sale();
}

/**
 * 类型:台式机
 */
class Desktop implements OldComputer {

    @Override
    public void sale() {
        System.out.println("销售台式机");
    }
}

/**
 * 类型:笔记本
 */
class Laptop implements OldComputer {

    @Override
    public void sale() {
        System.out.println("销售笔记本");
    }
}

/**
 * 类型:平板
 */
class Pad implements OldComputer {

    @Override
    public void sale() {
        System.out.println("销售平板");
    }
}

/**
 * 联想台式机
 */
class LenoveDesktop extends Desktop {
    @Override
    public void sale() {
        System.out.println("销售联想台式电脑");
    }
}

/**
 * 联想笔记本
 */
class LenoveLaptop extends Laptop {
    @Override
    public void sale() {
        System.out.println("销售联想笔记本");
    }
}

/**
 * 联想平板
 */
class LenovePad extends Pad {
    @Override
    public void sale() {
        System.out.println("销售联想平板");
    }
}

/**
 * 华硕台式机
 */
class AsusDesktop extends Desktop {
    @Override
    public void sale() {
        System.out.println("销售华硕台式电脑");
    }
}

/**
 * 华硕笔记本
 */
class AsusLaptop extends Laptop {
    @Override
    public void sale() {
        System.out.println("销售华硕笔记本");
    }
}

/**
 * 华硕平板
 */
class AsusPad extends Pad {
    @Override
    public void sale() {
        System.out.println("销售华硕平板");
    }
}
