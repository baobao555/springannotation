package com.baobao.springannotation.ioc.ext.beanfactorypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author baobao
 * @create 2020-02-11 16:59
 * @description
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    /**
     * 在BeanFactory初始化之后(所有的bean定义已经保存加载到beanFactory，但是bean的实例还未创建)调用，
     * 来定制和修改BeanFactory的内容
     * @param beanFactory 保存了容器中所有bean定义信息的工厂
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanFactoryPostProcessor.postProcessBeanFactory");
        //获取beanFactory中定义bean的个数
        int beanCount = beanFactory.getBeanDefinitionCount();
        //获取beanFactory中定义的所有bean的id
        String[] beanNames = beanFactory.getBeanDefinitionNames();
        System.out.println("当前beanFactory中有" + beanCount + "个bean，它们是：" + Arrays.asList(beanNames));
    }
}
