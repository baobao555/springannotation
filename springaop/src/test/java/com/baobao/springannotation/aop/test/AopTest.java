package com.baobao.springannotation.aop.test;

import com.baobao.springannotation.aop.bean.MathCalculator;
import com.baobao.springannotation.aop.config.AnnotationConfigAOP;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author baobao
 * @create 2020-02-11 15:09
 * @description
 */
public class AopTest {
    @Test
    public void testAop(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfigAOP.class);
        MathCalculator mathCalculator = context.getBean(MathCalculator.class);
        mathCalculator.divide(5, 1);
        mathCalculator.divide(5, 0);
    }
}
