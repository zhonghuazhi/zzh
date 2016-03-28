package com.smart.test1;

/**
 * 服务员
 * Created by zhonghua on 16/3/7.
 */
public interface Waiter {

    /**
     * 欢迎
     *
     * @param name
     */
    public void greetTo(String name);

    /**
     * 服务
     *
     * @param name
     */
    public void serveTo(String name);
}