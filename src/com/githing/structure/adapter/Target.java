package com.githing.structure.adapter;

/**
 * Created by qile on 16-12-13.
 * 客户的接口,相当与笔记本的USB接口
 * 里面有一个连接发送请求的动作
 */
public interface Target {
    void handleRequest();
}
