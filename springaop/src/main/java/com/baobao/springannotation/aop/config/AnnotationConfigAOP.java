package com.baobao.springannotation.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author baobao
 * @create 2020-02-11 12:06
 * @description
 */
@EnableAspectJAutoProxy
@ComponentScan("com.baobao.springannotation.aop.bean")
@Configuration
public class AnnotationConfigAOP {
}
