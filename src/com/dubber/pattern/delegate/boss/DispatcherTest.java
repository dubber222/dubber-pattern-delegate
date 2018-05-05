package com.dubber.pattern.delegate.boss;

/**
 * Created by dubber on 2018/5/5.
 */
public class DispatcherTest {

    public static void main(String[] args) {

        // 客户请求（Boss） ， 委派者(Leader)，被委派者(employee1,employee2)
        //  委派者要持有被委派者的医用
        // 代理模式注重的是过程，委派模式注重的是结果
        // 策略模式注重的是可扩展，    委派模式注重的是内部的灵活和复用

        // 委派模式： 就是静态代理和策略模式的结合。
        new Boss().doing("test");
    }
}
