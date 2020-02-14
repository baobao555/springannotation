package com.baobao.springannotation.ioc.ext.applicationlistener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author baobao
 * @create 2020-02-11 17:54
 * @description
 */
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {
    /**
     * 收到发布的事件时回调
     * @param event 事件对象
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("MyApplicationListener收到事件" + event);
    }
}
