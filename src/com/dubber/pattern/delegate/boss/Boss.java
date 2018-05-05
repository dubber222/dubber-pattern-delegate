package com.dubber.pattern.delegate.boss;

/**
 * Created by dubber on 2018/5/5.
 */
public class Boss implements TaskI{


    @Override
    public void doing(String instruct) {
        new Leader().doing(instruct);
    }
}
