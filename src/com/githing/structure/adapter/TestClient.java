package com.githing.structure.adapter;

/**
 * Created by qile on 16-12-13.
 * 客户请求类
 * 客户希望实现打字功能,但是需要通过适配器去实现
 */
public class TestClient {

    /**
     * 请求打字
     *
     * @param target
     */
    public void request(Target target) {
        target.handleRequest();
    }

    public static void main(String[] args) {
        TestClient client = new TestClient();
        client.request(client.combinationAdapter());
        client.request(client.classAdapter());
    }

    /**
     * 使用对象组合的适配器测试
     */
    private Target combinationAdapter() {
        //返回一个适配器,适配器中需要传入KeyBoard对象
        return new CombinationAdapter(new KeyBoard());
    }

    /**
     * 使用类适配器
     *
     * @return
     */
    private Target classAdapter() {
        return new ClassAdapter();
    }

}
