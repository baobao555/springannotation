package com.baobao.springannotation.ioc.test;

import com.baobao.springannotation.ioc.bean.Person;
import com.baobao.springannotation.ioc.config.*;
import com.baobao.springannotation.ioc.dao.PersonDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * @author baobao
 * @create 2020-02-09 9:39
 * @description
 */
public class IOCTest {

    //传统xml方式获取bean
    @Test
    public void testOldXmlConfig(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person oldPerson = context.getBean("oldPerson", Person.class);
        System.out.println(oldPerson);
    }

    //注解配置类方式获取bean
    //方式一：配置类中声明方法注册bean
    @Test
    public void testAnnotationConfig(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
    }

    //方式二：组件扫描
    @Test
    public void testComponentScan(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        //获取ioc容器中所有注册的bean的id名
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    //方式三：@Import
    @Test
    public void testImport(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig2.class);
        //获取ioc容器中所有注册的bean的id名
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        Object bean = context.getBean("com.baobao.springannotation.ioc.bean.Green");
        System.out.println("bean:" + bean);

        System.out.println(context.getBean("pink"));
    }

    //方式四：FactoryBean接口
    @Test
    public void testFactoryBean(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig2.class);
        //获取ioc容器中所有注册的bean的id名
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        //调用personFactory生产一个Person
        System.out.println(context.getBean("personFactory"));
        //获取personFactory本身
        System.out.println(context.getBean("&personFactory"));
    }

    //测试Condition
    @Test
    public void testCondition(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig2.class);
        //获取ioc容器中所有注册的bean的id名
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println(context.getBean("bill"));
        System.out.println(context.getBean("linus"));
    }

    //测试生命周期
    @Test
    public void testLifeCycle(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfigLifeCycle.class);
        //获取car对象
        context.getBean("car");
        //关闭容器，销毁car
        context.close();
    }

    //测试外部配置文件和@Value
    @Test
    public void testPropertyValue(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfigPropertyValue.class);
        System.out.println(context.getBean("dataSource"));
    }

    //测试自动装配
    @Test
    public void testAutoware(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfigAutoware.class);
        //获取容器中所有类型为PersonDao.class的bean对象并打印
        String[] beanNamesForType = context.getBeanNamesForType(PersonDao.class);
        for (String name : beanNamesForType) {
            Object bean = context.getBean(name);
            System.out.println(name + ":" + bean);
        }
        //打印personService
        System.out.println(context.getBean("personService"));
    }

    //测试自动装配2
    @Test
    public void testAutoware2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfigAutoware.class);
        System.out.println("IOC容器中的Pink：" + context.getBean("pink"));
    }

    //测试@Profile
    @Test
    public void testProfile(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfigProfile.class);
        String[] dataSources = context.getBeanNamesForType(DataSource.class);
        for (String dataSource : dataSources) {
            System.out.println(dataSource);
        }
    }

    //测试@Profile:代码激活环境
    @Test
    public void testProfile2(){
        //无参构造函数创建AnnotationConfigApplicationContext
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //设置需要激活的环境
        context.getEnvironment().setActiveProfiles("dev","prod");
        //注册注解配置类
        context.register(AnnotationConfigProfile.class);
        //启动刷新容器
        context.refresh();
        String[] dataSources = context.getBeanNamesForType(DataSource.class);
        for (String dataSource : dataSources) {
            System.out.println(dataSource);
        }
    }
}
