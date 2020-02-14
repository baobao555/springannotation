package com.baobao.springannotation.ioc.controller;

import com.baobao.springannotation.ioc.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author baobao
 * @create 2020-02-09 10:37
 * @description
 */
@Controller
public class PersonController {
    @Autowired
    private PersonService personService;
}
