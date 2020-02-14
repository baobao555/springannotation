package com.baobao.springannotation.ioc.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author baobao
 * @create 2020-02-09 15:14
 * @description
 */
public class PersonFactory implements FactoryBean<Person> {
    @Override
    public Person getObject() throws Exception {
        return new Person();
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
