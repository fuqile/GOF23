package com.githing.structure.proxy.dynamicProxy;

import com.githing.structure.proxy.Star;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by qile on 16-12-14.
 *
 * 动态代理实现类,需要实现InvocationHandler接口
 *
 */
public class StarHandler implements InvocationHandler {

    Star realStar;

    public StarHandler(Star realStar) {
        this.realStar = realStar;
    }

    /**
     * 使用这个handler代理的所有调用都会执行到这里面
     * @param proxy  代理类
     * @param method 调用的方法
     * @param args   方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("真正的方法执行开始");
        Object object = null;

        //中间可以做一些根据判断或需求操作,哪些要哪些不要
        if(method.getName().equals("sing")){
            object = method.invoke(realStar, args);
        }
        System.out.println("真正的方法执行结束");
        return object;
    }
}
