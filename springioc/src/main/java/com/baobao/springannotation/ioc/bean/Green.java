package com.baobao.springannotation.ioc.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author baobao
 * @create 2020-02-09 11:53
 * @description
 */
public class Green implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(applicationContext);
        //将注入的ApplicationContext保存为属性，以便后续使用
        this.applicationContext = applicationContext;
    }
}
