package com.baobao.springannotation.tx.test;

import com.baobao.springannotation.tx.config.AnnotationConfigTx;
import com.baobao.springannotation.tx.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author baobao
 * @create 2020-02-11 16:06
 * @description
 */
public class TxTest {
    @Test
    public void testTx(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfigTx.class);
        UserService userService = context.getBean(UserService.class);
        userService.insertUser("baobao3","123456");
    }
}
