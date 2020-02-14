package com.baobao.springannotation.tx.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


/**
 * @author baobao
 * @create 2020-02-11 15:48
 * @description
 */
@EnableTransactionManagement //开启注解事务的功能
@Configuration
@ComponentScan("com.baobao.springannotation.tx.service")
public class AnnotationConfigTx {

    //配置数据源
    @Bean
    public DataSource dataSource() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:10020/baobao_test");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    //配置SqlSessionFactoryBean
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(/*注入数据源*/DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        return sqlSessionFactory;
    }

    //配置mapper接口扫描器
    @Bean
    public MapperScannerConfigurer mapperScanner(){
        MapperScannerConfigurer mapperScanner = new MapperScannerConfigurer();
        //指定要扫描的包，即mapper接口所在的包
        mapperScanner.setBasePackage("com.baobao.springannotation.tx.dao");
        return mapperScanner;
    }

    //配置事务管理器
    @Bean
    public DataSourceTransactionManager transactionManager(/*注入数据源*/DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        return transactionManager;
    }
}
