package com.baobao.springannotation.ioc.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author baobao
 * @create 2020-02-09 15:28
 * @description
 */
public class WindowsCondition implements Condition {
    /**
     * 判断是否Windows系统
     * @param context 判断条件能使用的上下文（环境）
     * @param metadata 注释信息
     * @return true表示条件成立，将对应的bean加入ioc容器中；false表示条件不成立，不加入容器中
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //1、能获取到ioc使用的beanfactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //2、获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        //3、获取当前环境信息
        Environment environment = context.getEnvironment();
        //4、获取到bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();
        //可以判断容器中的bean注册情况，也可以给容器中注册bean
        boolean definition = registry.containsBeanDefinition("person");

        //获取当前操作系统信息
        String osName = environment.getProperty("os.name");
        //判断是否是Windows操作系统
        return osName.contains("Windows");
    }
}
