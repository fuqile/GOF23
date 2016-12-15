package com.githing.structure.proxy;


import com.githing.structure.proxy.dynamicProxy.StarHandler;
import com.githing.structure.proxy.staticProxy.ProxyStar;

import java.lang.reflect.Proxy;

/**
 * Created by qile on 16-12-14.
 */
public class TestClient {

    public static void main(String[] args) {
        TestClient client = new TestClient();
        client.staticProxy();
        client.dynamicProxy();
    }

    /**
     * 静态代理测试
     */
    public void staticProxy() {
        //真实的明星
        Star real = new RealStar();
        //代理人
        Star proxy = new ProxyStar(real);

        //调用代理的方法
        proxy.confer();
        proxy.signContract();
        proxy.bookTicket();
        //代理有这个方法,但是代理实际上不会唱歌,需要调用真实的明星去唱歌
        //客户端调用无感知
        proxy.sing();
        proxy.conllectMoney();

    }

    /**
     * 动态代理测试
     */
    public void dynamicProxy() {
        Star realStar = new RealStar();
        StarHandler handler = new StarHandler(realStar);
        //使用JDK自带的Proxy类动态生成代理
        Star proxyStar = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Star.class}, handler);
        //sing方法会执行,bookTicket方法不会执行
        //因为在StarHandler中做了个限制,当只有调用方法名为sing的时候才会执行
        proxyStar.sing();
        proxyStar.bookTicket();
    }


}
