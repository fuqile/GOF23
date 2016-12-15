package com.githing.structure.proxy;

/**
 * Created by qile on 16-12-14.
 * 真实的明星
 * 拥有接口下的所有操作
 */
public class RealStar implements Star {
    @Override
    public void confer() {
        System.out.println("Real confer");
    }

    @Override
    public void signContract() {
        System.out.println("Real signContract");

    }

    @Override
    public void bookTicket() {
        System.out.println("Real bookTicket");

    }

    @Override
    public void sing() {
        System.out.println("Real sing");
    }

    @Override
    public void conllectMoney() {
        System.out.println("Real conllectMoney");
    }
}
