package com.baobao.springannotation.ioc.config;

import com.baobao.springannotation.ioc.Importbeandefinitionregistrar.MyImportBeanDefinitionRegistrar;
import com.baobao.springannotation.ioc.bean.Green;
import com.baobao.springannotation.ioc.bean.Person;
import com.baobao.springannotation.ioc.bean.PersonFactory;
import com.baobao.springannotation.ioc.bean.Red;
import com.baobao.springannotation.ioc.condition.LinuxCondition;
import com.baobao.springannotation.ioc.condition.WindowsCondition;
import com.baobao.springannotation.ioc.importselector.MyImportSelector;
import com.baobao.springannotation.ioc.typefilter.MyTypeFilter;
import org.springframework.context.annotation.*;


/**
 * @author baobao
 * @create 2020-02-09 10:01
 * @description 演示@Import
 */


//@Conditional(WindowsCondition.class) 类中组件统一设置。满足当前条件，这个类中配置的所有bean注册才能生效
@Configuration //告诉Spring这是一个配置类，配置类==配置文件
@Import({Red.class, Green.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class AnnotationConfig2 {
    @Bean
    public PersonFactory personFactory(){
        return new PersonFactory();
    }

    //应用Windows操作系统的条件，如果是Windows操作系统，bill生效
    @Conditional(WindowsCondition.class)
    @Bean("bill")
    public Person person1(){
        return new Person("Bill Gates", 60);
    }
    //应用Linux操作系统的条件，如果是Windows操作系统，linus生效
    @Conditional(LinuxCondition.class)
    @Bean("linus")
    public Person person2(){
        return new Person("Linus", 58);
    }
}
