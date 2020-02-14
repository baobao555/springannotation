package com.baobao.springannotation.aop.bean;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author baobao
 * @create 2020-02-11 12:12
 * @description
 */
@Component
@Aspect
public class LoggingAspect {

    //定义切入点表达式方法，方便后面重用切入点表达式
    @Pointcut("execution(public int com.baobao.springannotation.aop.bean.MathCalculator.divide(int,int))")
    public void pointCut(){
    }

    //前置通知
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        //获取切入点的方法名称
        String methodName = joinPoint.getSignature().getName();
        //获取列入点方法的参数列表
        Object[] args = joinPoint.getArgs();
        System.out.println("前置通知logStart:" + methodName + "方法被执行，参数是" + Arrays.asList(args));
    }

    //后置通知
    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint){
        //获取切入点的方法名称
        String methodName = joinPoint.getSignature().getName();
        //获取列入点方法的参数列表
        Object[] args = joinPoint.getArgs();
        System.out.println("后置通知logEnd:" + methodName + "方法被执行，参数是" + Arrays.asList(args));
    }

    //正常返回通知，returning指定通知方法哪个形参用于接收返回值
    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result){
        //获取切入点的方法名称
        String methodName = joinPoint.getSignature().getName();
        //获取列入点方法的参数列表
        Object[] args = joinPoint.getArgs();
        System.out.println("返回通知logReturn:" + methodName + "方法被执行，参数是" + Arrays.asList(args)
        + "返回值是：" + result);
    }

    //异常返回通知，throwing指定通知方法哪个形参用于接收异常信息
    @AfterThrowing(value = "pointCut()",throwing = "ex")
    public void logException(JoinPoint joinPoint,Exception ex){
        //获取切入点的方法名称
        String methodName = joinPoint.getSignature().getName();
        //获取列入点方法的参数列表
        Object[] args = joinPoint.getArgs();
        System.out.println("返回通知logReturn:" + methodName + "方法被执行，参数是" + Arrays.asList(args)
                + "出现了异常：" + ex);
    }
}
