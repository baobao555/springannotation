package com.baobao.springannotation.ioc.config;

import com.baobao.springannotation.ioc.bean.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author baobao
 * @create 2020-02-10 9:17
 * @description
 */
@Configuration
@PropertySource("classpath:db-config.properties")
public class AnnotationConfigPropertyValue {
    @Bean
    public DataSource dataSource(){
        return new DataSource();
    }
}
