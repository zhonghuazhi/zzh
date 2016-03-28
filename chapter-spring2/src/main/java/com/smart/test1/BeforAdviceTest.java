package com.smart.test1;

import org.junit.Before;
import org.junit.Test;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * Created by zhonghua on 16/3/7.
 */
public class BeforAdviceTest {

    private Waiter waiter;

    private BeforeAdvice beforeAdvice;

    private AfterReturningAdvice afterReturningAdvice;

    private ProxyFactory proxyFactory;


    @Before
    public void init() {

        waiter = new NaiveWaiter();
        beforeAdvice = new GreetingBeforAdvice();
        afterReturningAdvice = new AfterReturningAdvice() {
            @Override
            public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
                System.out.println("Good By ... " + method.getName() + "\n\n\n");
            }
        };

        proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(waiter);
        proxyFactory.addAdvice(beforeAdvice);
        proxyFactory.addAdvice(afterReturningAdvice);
    }

    @Test
    public void setBeforeAdvice() {

        Waiter proxy = (Waiter) proxyFactory.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("Tom");

    }
}