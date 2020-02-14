package com.baobao.springannotation.aop.bean;

import org.springframework.stereotype.Component;

/**
 * @author baobao
 * @create 2020-02-11 12:11
 * @description
 */
@Component
public class MathCalculator {
    public int divide(int x,int y){
        return x / y;
    }
}
