package com.baobao.springannotation.ioc.config;

import com.baobao.springannotation.ioc.bean.DataSource;
import com.baobao.springannotation.ioc.bean.Pink;
import com.baobao.springannotation.ioc.bean.Red;
import com.baobao.springannotation.ioc.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

/**
 * @author baobao
 * @create 2020-02-10 9:17
 * @description
 */
@Configuration
@ComponentScan({"com.baobao.springannotation.ioc.dao","com.baobao.springannotation.ioc.service",
        "com.baobao.springannotation.ioc.bean"})
public class AnnotationConfigAutoware {
    @Primary //将personDao2作为PersonService首选注入的对象
    @Bean //容器中加入personDao2
    public PersonDao personDao2(){
        return new PersonDao();
    }

    //@Autowired
    @Bean
    public Red red(/*@Autowired*/ Pink pink){
        System.out.println("装配给Red的Pink：" + pink);
        Red red = new Red();
        red.setPink(pink);
        return red;
    }

}
