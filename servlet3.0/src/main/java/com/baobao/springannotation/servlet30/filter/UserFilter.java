package com.baobao.springannotation.servlet30.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author baobao
 * @create 2020-02-12 17:19
 * @description
 */
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("UserFilter.init()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("UserFilter.doFilter()");
        //放行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("UserFilter.destroy()");
    }
}
