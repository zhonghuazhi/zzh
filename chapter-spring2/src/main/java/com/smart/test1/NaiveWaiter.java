package com.smart.test1;

import com.smart.test1.Waiter;

/**
 * Created by zhonghua on 16/3/7.
 */
public class NaiveWaiter implements Waiter {

    @Override
    public void greetTo(String name) {
        System.out.println("greet to " + name + " ...");
    }

    @Override
    public void serveTo(String name) {
        System.out.println("serve to " + name + " ...");
    }
}