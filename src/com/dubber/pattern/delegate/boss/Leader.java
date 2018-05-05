package com.dubber.pattern.delegate.boss;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dubber on 2018/5/5.
 */
public class Leader implements TaskI{


    Map<String,TaskI> mapping = new HashMap<String,TaskI>(){{
       put("develop",new Employee1());
       put("test",new Employee2());
    }};

    @Override
    public void doing(String instruct) {
        System.out.println("我会产品经理现在分发Boss指令");
        mapping.get(instruct).doing(instruct);
    }
}
