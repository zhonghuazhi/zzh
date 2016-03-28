package com.smart.test1;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by zhonghua on 16/3/7.
 */
public class GreetingBeforAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {

        String clientName = objects[0].toString();
        System.out.println(method.getName());
        System.out.println("How ar you Mr. " + clientName + " .");
    }
}