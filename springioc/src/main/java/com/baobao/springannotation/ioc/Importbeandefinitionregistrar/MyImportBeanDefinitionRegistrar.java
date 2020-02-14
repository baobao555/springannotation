package com.baobao.springannotation.ioc.Importbeandefinitionregistrar;

import com.baobao.springannotation.ioc.bean.Pink;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author baobao
 * @create 2020-02-09 12:10
 * @description
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * 把所有需要添加到容器中的bean,调用BeanDefinitionRegistry.registerBeanDefinition手工注册进来
     * @param importingClassMetadata 当前类的注解信息
     * @param registry BeanDefinition注册类
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //判断容器中是否含有Red类型的bean
        boolean hasRed = registry.containsBeanDefinition("com.baobao.springannotation.ioc.bean.Red");
        if (hasRed){
            //创建Pink的bean定义
            BeanDefinition beanDef = new RootBeanDefinition(Pink.class);
            //手动向容器中注册Pink，id为"pink"
            registry.registerBeanDefinition("pink", beanDef);
        }
    }
}
