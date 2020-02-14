package com.baobao.springannotation.ioc.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author baobao
 * @create 2020-02-09 17:28
 * @description
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    /**
     * 初始化之前调用
     * @param bean 当前初始化的bean
     * @param beanName 当前初始化的bean的id
     * @return 创建好的bean对象
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor.postProcessBeforeInitialization:" + beanName + ":" + bean);
        return bean;
    }

    /**
     * 初始化之后调用
     * @param bean 当前初始化的bean
     * @param beanName 当前初始化的bean的id
     * @return 创建好的bean对象
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor.postProcessAfterInitialization:" + beanName + ":" + bean);
        return bean;
    }
}
