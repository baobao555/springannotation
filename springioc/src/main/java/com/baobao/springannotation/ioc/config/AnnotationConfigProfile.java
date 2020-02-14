package com.baobao.springannotation.ioc.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;
import javax.sql.DataSource;

/**
 * @author baobao
 * @create 2020-02-10 9:17
 * @description 演示@Profile，根据不同场景动态切换注册的bean
 */

/**
 * @Profile：指定组件在哪个环境的情况下才能被注册到容器中，不指定，任何环境下都能注册这个组件
 *
 * 1）、加了环境标识的bean，只有这个环境被激活的时候才能注册到容器中。默认是default环境
 * 2）、写在配置类上，只有是指定的环境的时候，整个配置类里面的所有配置才能开始生效
 * 3）、没有标注环境标识的bean在任何环境下都是加载的；
 */
//@Profile("test") 可以标在类上，表示只有环境激活的时候整个类中所有bean才能被加入到容器中
@Configuration
@PropertySource("classpath:db-config.properties")//指定外部配置文件路径
public class AnnotationConfigProfile implements EmbeddedValueResolverAware {

    @Value("${jdbc.user}")//从配置文件取值赋值给属性
    private String username;

    private String driverClass;
    //注入字符串解析器
    private StringValueResolver resolver;

    //测试环境
    @Profile("test")
    @Bean
    public DataSource dataSourceTest(/*从配置文件取值赋值给参数*/@Value("${jdbc.password}") String password) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(this.driverClass);
        dataSource.setUser(this.username);
        dataSource.setPassword(password);
        //根据不同的环境设置连接到不同表的url
        dataSource.setJdbcUrl("jdbc:mysql://localhost:10020/test");
        return dataSource;
    }

    //测试环境
    @Profile("dev")
    @Bean
    public DataSource dataSourceDev(/*从配置文件取值赋值给参数*/@Value("${jdbc.password}") String password) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(this.driverClass);
        dataSource.setUser(this.username);
        dataSource.setPassword(password);
        //根据不同的环境设置连接到不同表的url
        dataSource.setJdbcUrl("jdbc:mysql://localhost:10020/employees");
        return dataSource;
    }

    //测试环境
    @Profile("prod")
    @Bean
    public DataSource dataSourceProd(/*从配置文件取值赋值给参数*/@Value("${jdbc.password}") String password) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(this.driverClass);
        dataSource.setUser(this.username);
        dataSource.setPassword(password);
        //根据不同的环境设置连接到不同表的url
        dataSource.setJdbcUrl("jdbc:mysql://localhost:10020/departments");
        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        //获取注入的字符串解析器
        this.resolver = resolver;
        //解析外部配置文件取值的字符串，将解析后的值保存
        this.driverClass = resolver.resolveStringValue("${jdbc.driverClass}");
    }
}
