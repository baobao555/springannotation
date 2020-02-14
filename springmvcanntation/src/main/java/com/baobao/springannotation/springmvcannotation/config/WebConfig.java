package com.baobao.springannotation.springmvcannotation.config;

import com.baobao.springannotation.springmvcannotation.intercept.MyInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author baobao
 * @create 2020-02-13 11:55
 * @description
 */
//只扫描Controller，注意要用useDefaultFilters = false禁用掉默认扫描规则
@ComponentScan(value = "com.baobao.springannotation.springmvcannotation",includeFilters =
@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class),
useDefaultFilters = false)
@EnableWebMvc//相当于xml配置<mvc:annotation-driven/>
public class WebConfig extends WebMvcConfigurerAdapter {
    //配置视图解析器
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        //指定解析的前缀、后缀
        registry.jsp("/WEB-INF/pages/", ".jsp");
    }

    //配置静态资源访问，相当于xml配置<mvc:default-servlet-handler/>
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new MyInterceptor());
        //给拦截器配置拦截路径
        interceptorRegistration.addPathPatterns("/**");
    }
}
