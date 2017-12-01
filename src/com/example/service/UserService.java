package com.example.service;

import com.example.pojo.User;

public interface UserService {
    //用户注册
    boolean register(User user);

    //用户登录
    User login(String admin,String password);
}
