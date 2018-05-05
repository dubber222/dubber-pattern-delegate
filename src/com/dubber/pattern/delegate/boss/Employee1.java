package com.dubber.pattern.delegate.boss;

/**
 * Created by dubber on 2018/5/5.
 */
public class Employee1 implements TaskI{
    @Override
    public void doing(String instruct) {
        System.out.println("我的任务是 -------开发------");

    }
}
