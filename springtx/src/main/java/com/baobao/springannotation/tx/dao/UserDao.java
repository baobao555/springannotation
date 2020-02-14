package com.baobao.springannotation.tx.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @author baobao
 * @create 2020-02-11 15:47
 * @description
 */
public interface UserDao {
    @Insert("insert into user(name,password) values(#{username},#{password})")
    void insertUser(@Param("username") String username, @Param("password") String password);
}
