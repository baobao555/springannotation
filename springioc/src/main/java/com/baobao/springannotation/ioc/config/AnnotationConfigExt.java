package com.baobao.springannotation.ioc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author baobao
 * @create 2020-02-11 17:05
 * @description
 */
@Configuration
@ComponentScan({"com.baobao.springannotation.ioc.ext","com.baobao.springannotation.ioc.beanpostprocessor"})
public class AnnotationConfigExt {
}
