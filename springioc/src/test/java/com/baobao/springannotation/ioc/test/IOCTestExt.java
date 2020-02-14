package com.baobao.springannotation.ioc.test;

import com.baobao.springannotation.ioc.config.AnnotationConfigExt;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author baobao
 * @create 2020-02-11 17:06
 * @description
 */
public class IOCTestExt {
    @Test
    public void testBeanFactoryPostProcessor(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfigExt.class);
    }

    @Test
    public void testApplicationListener(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfigExt.class);
        //发布自定义事件
        context.publishEvent(new ApplicationEvent("我发布的事件") {
        });
        context.close();
    }
}
