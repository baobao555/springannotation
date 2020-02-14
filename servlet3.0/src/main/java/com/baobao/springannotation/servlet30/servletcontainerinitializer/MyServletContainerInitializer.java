package com.baobao.springannotation.servlet30.servletcontainerinitializer;

import com.baobao.springannotation.servlet30.filter.UserFilter;
import com.baobao.springannotation.servlet30.listener.UserListener;
import com.baobao.springannotation.servlet30.service.HelloService;
import com.baobao.springannotation.servlet30.servlet.UserServlet;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;

/**
 * @author baobao
 * @create 2020-02-12 17:17
 * @description
 */

//传入感兴趣的类型:容器启动的时候会将@HandlesTypes指定的这个类型下面的子类（实现类，子接口等）传递过来
@HandlesTypes({HelloService.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {
    /**
     * 应用启动的时候，会运行onStartup方法
     * @param set @HandlesTypes中声明的感兴趣的类的所有子类型（实现类，子接口等）
     * @param servletContext 代表当前Web应用的ServletContext，一个Web应用一个ServletContext
     * @throws ServletException
     */
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        //打印所有传入的感兴趣的类型
        System.out.println("感兴趣的类型:");
        for (Class<?> clazz : set) {
            System.out.println(clazz);
        }

        //注册Servlet
        ServletRegistration.Dynamic userServlet = servletContext.addServlet("userServlet", new UserServlet());
        //指定Servlet的映射路径
        userServlet.addMapping("/user");

        //注册Filter
        FilterRegistration.Dynamic userFilter = servletContext.addFilter("userFilter", UserFilter.class);
        //指定Filter需要过滤的路径
        userFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");

        //注册Listener
        servletContext.addListener(UserListener.class);
    }
}
