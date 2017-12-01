package com.example.dao.mapper;

import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Qualifier;

public interface UserMapper {

    //用户登录
    User selectUser(String admin,String password);

    //用户注册
    void insertUser(String admin,String password,String username);
}
