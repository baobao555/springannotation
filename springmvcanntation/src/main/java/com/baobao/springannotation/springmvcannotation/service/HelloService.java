package com.baobao.springannotation.springmvcannotation.service;

import org.springframework.stereotype.Service;

/**
 * @author baobao
 * @create 2020-02-13 12:10
 * @description
 */
@Service
public class HelloService {
    public String sayHello(String toWhom){
        return "Hello " + toWhom;
    }
}
