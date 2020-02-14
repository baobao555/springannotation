package com.baobao.springannotation.ioc.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author baobao
 * @create 2020-02-09 16:56
 * @description 测试声明周期
 */
public class Car implements InitializingBean, DisposableBean {
    public Car(){
        System.out.println("Car的构造函数");
    }

    public void initCar(){
        System.out.println("Car init()");
    }

    public void destroyCar(){
        System.out.println("Car destroy()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Car:InitializingBean.afterPropertiesSet()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Car:DisposableBean.destroy()");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("Car: @PostConstruct");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("Car: @PreDestroy");
    }
}
