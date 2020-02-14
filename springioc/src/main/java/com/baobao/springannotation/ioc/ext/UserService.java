package com.baobao.springannotation.ioc.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author baobao
 * @create 2020-02-12 9:35
 * @description
 */
@Component
public class UserService {
    @EventListener(classes = {ApplicationEvent.class})
    public void listen(ApplicationEvent event){
        System.out.println("UserService.listen收到事件：" + event);
    }
}
