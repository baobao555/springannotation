package com.baobao.springannotation.springmvcannotation;

import com.baobao.springannotation.springmvcannotation.config.SpringRootConfig;
import com.baobao.springannotation.springmvcannotation.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author baobao
 * @create 2020-02-13 12:15
 * @description
 */
public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    //获取根容器的注解配置类（Spring的配置文件）->父容器
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringRootConfig.class};
    }

    //获取web容器的注解配置类（SpringMVC配置文件）->子容器
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    //获取DispatcherServlet的映射信息
    //  /：拦截所有请求（包括静态资源（xx.js,xx.png）），但是不包括*.jsp；
    //  /*：拦截所有请求；连*.jsp页面都拦截；jsp页面是tomcat的jsp引擎解析的；
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
