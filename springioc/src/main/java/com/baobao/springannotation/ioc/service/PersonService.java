package com.baobao.springannotation.ioc.service;

import com.baobao.springannotation.ioc.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author baobao
 * @create 2020-02-09 10:38
 * @description
 */
@Service
public class PersonService {
    @Qualifier("personDao")//利用指定的id去容器中获取并装配，而不是用属性名"dao"作为id去容器中找
    @Autowired(required = false)
    private PersonDao dao;

    @Override
    public String toString() {
        return "PersonService{" +
                "personDao=" + dao +
                '}';
    }
}
