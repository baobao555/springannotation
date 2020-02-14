package com.baobao.springannotation.ioc.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author baobao
 * @create 2020-02-10 9:17
 * @description
 *
 * 使用@Value赋值；
 * 	1、基本数值
 * 	2、可以写SpEL； #{}
 * 	3、可以写${}；取出配置文件【properties】中的值（在运行环境变量里面的值）
 */
public class DataSource {
    //字符串
    @Value("PooledDataSource")
    private String name;
    //SpEL表达式
    @Value("#{20 - 2}")
    private int count;

    //从外部配置文件取值
    @Value("${jdbc.driverClass}")
    private String driver;
    @Value("${jdbc.jdbcUrl}")
    private String url;
    @Value("${jdbc.user}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Override
    public String toString() {
        return "DataSource{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
