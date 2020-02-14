package com.baobao.springannotation.ioc.config;

import com.baobao.springannotation.ioc.bean.Green;
import com.baobao.springannotation.ioc.bean.Person;
import com.baobao.springannotation.ioc.bean.Red;
import com.baobao.springannotation.ioc.typefilter.MyTypeFilter;
import org.springframework.context.annotation.*;



/**
 * @author baobao
 * @create 2020-02-09 10:01
 * @description Spring注解配置类，代替xml配置文件
 */


@ComponentScans({
        //扫描com.baobao.springannotation.ioc
        //配置includeFilters，指定扫描哪些组件
        @ComponentScan(value = "com.baobao.springannotation.ioc", includeFilters = {
                /*//扫描规则1：扫描@Controller组件
                @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class),
                //扫描规则2：扫描PersonService和PersonDao类型的组件
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {PersonService.class, PersonDao.class})*/
                //使用自定义规则的过滤器
                @ComponentScan.Filter(type = FilterType.CUSTOM,classes = MyTypeFilter.class)
          //禁用默认的扫描规则
        },useDefaultFilters = false)
})
@Configuration //告诉Spring这是一个配置类，配置类==配置文件
public class AnnotationConfig {
   /* 给容器中注册一个Bean,类型为返回值的类型
    id默认是用方法名作为id，可以用@Bean注解的value指定id*/
    @Scope("singleton") //单例还是多例
    @Lazy //单例情况下指定懒加载，即不在容器创建的时候就马上创建单例对象，而是等到获取的时候再创建
    @Bean("person") //将方法返回的bean加入ioc容器，value指定id
    public Person person01(){
        System.out.println("创建Person对象");
        return new Person("baobao",28);
    }
}
