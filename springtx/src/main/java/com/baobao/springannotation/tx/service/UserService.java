package com.baobao.springannotation.tx.service;

import com.baobao.springannotation.tx.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author baobao
 * @create 2020-02-11 15:47
 * @description
 */
@Service//加入到IOC容器
public class UserService {
    @Autowired //注入Dao
    private UserDao userDao;

    @Transactional //声明为事务方法
    public void insertUser(String username,String password){
        System.out.println("UserService.insertUser()");
        userDao.insertUser(username, password);
        int i = 5 / 0;
    }
}
