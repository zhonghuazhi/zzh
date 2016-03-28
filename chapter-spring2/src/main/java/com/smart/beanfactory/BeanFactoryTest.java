package com.smart.beanfactory;

import com.smart.beanfactory.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.beans.Beans;

/**
 * Created by zhonghua on 16/3/2.
 */
public class BeanFactoryTest {

    public static void main(String[] args) throws Exception{

        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        Car c1 = ctx.getBean("car1" , Car.class);
        Car c2 = ctx.getBean("car1" , Car.class);
        Car c3 = ctx.getBean("car1" , Car.class);
        Car c4 = ctx.getBean("car1" , Car.class);

    }
}
