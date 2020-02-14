package com.baobao.springannotation.springmvcannotation.controller;

import com.baobao.springannotation.springmvcannotation.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author baobao
 * @create 2020-02-13 12:11
 * @description
 */
@Controller
public class HelloController {
    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    public String hello(Model model){
        String hello = helloService.sayHello("baobao");
        model.addAttribute("hello",hello);
        return "success";
    }
}
