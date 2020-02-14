package com.baobao.springannotation.ioc.ext.beandefinitionregistrypostprocessor;

import com.baobao.springannotation.ioc.bean.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author baobao
 * @create 2020-02-11 17:24
 * @description
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    /**
     * 在所有bean定义信息将要被加载，bean实例还未创建时调用，可以给容器中再额外添加一些组件；
     * 优先于BeanFactoryPostProcessor执行
     * @param registry Bean定义信息的保存中心，以后BeanFactory就是按照BeanDefinitionRegistry
     *                 里面保存的每一个bean定义信息创建bean实例
     * @throws BeansException
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        //获取当前定义的bean的数量
        int count = registry.getBeanDefinitionCount();
        System.out.println("MyBeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry...bean的数量" + count);
        //注册一个新的bean
        registry.registerBeanDefinition("car", new RootBeanDefinition(Car.class));
    }

    /**
     * 来自于父接口BeanFactoryPostProcessor的方法
     * @param beanFactory 保存了容器中所有bean定义信息的工厂
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor.postProcessBeanFactory");
        //获取当前注册的bean的数量
        int count = beanFactory.getBeanDefinitionCount();
        System.out.println("---beanFactory中有" + count + "个bean");
    }
}
