package com.githing.structure.proxy.staticProxy;

import com.githing.structure.proxy.Star;

/**
 * Created by qile on 16-12-14.
 * 明星的代理
 * 拥有接口下的所有操作
 */
public class ProxyStar implements Star {

    private Star star;

    public ProxyStar(Star star) {
        this.star = star;
    }

    @Override
    public void confer() {
        System.out.println("Proxy confer");
    }

    @Override
    public void signContract() {
        System.out.println("Proxy signContract");

    }

    @Override
    public void bookTicket() {
        System.out.println("Proxy bookTicket");

    }

    @Override
    public void sing() {
        //代理不会唱歌,需要调用真实明星的唱歌方法
        star.sing();
    }

    @Override
    public void conllectMoney() {
        System.out.println("Proxy conllectMoney");
    }
}
