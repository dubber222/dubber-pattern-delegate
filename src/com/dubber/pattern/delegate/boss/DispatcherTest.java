package com.dubber.pattern.delegate.boss;

/**
 * Created by dubber on 2018/5/5.
 */
public class DispatcherTest {

    public static void main(String[] args) {

        // 客户请求

        // 委派模式： 就是静态代理和策略模式的结合。
        new Boss().doing("test");
    }
}
