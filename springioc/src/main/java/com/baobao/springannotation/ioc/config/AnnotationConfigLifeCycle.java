package com.baobao.springannotation.ioc.config;

import com.baobao.springannotation.ioc.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author baobao
 * @create 2020-02-09 16:22
 * @description
 */
@Configuration
@ComponentScan("com.baobao.springannotation.ioc.beanpostprocessor")
public class AnnotationConfigLifeCycle {
    @Bean(initMethod = "initCar",destroyMethod = "destroyCar")
    public Car car(){
        return new Car();
    }
}
