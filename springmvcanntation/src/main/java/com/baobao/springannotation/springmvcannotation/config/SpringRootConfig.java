package com.baobao.springannotation.springmvcannotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author baobao
 * @create 2020-02-13 11:51
 * @description
 */
//扫描所有组件，除了Controller
@ComponentScan(value = "com.baobao.springannotation.springmvcannotation",excludeFilters =
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class))
public class SpringRootConfig {
}
