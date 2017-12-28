package com.example.service.impl;

import com.example.Utils.SpringUtils;
import com.example.dao.mapper.UserMapper;
import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService{
    //自动装配
    @Autowired
    private UserMapper userMapper;
    /**
     * 用户注册
     * 帐号注册规范：6-10位大小写字母跟数字
     * 密码注册规范：6-10位大小写字母、数字和简单字符
     * 昵称注册规范：3-8位大小写字母及数字
     * @param user
     * @return -1 admin不符合规范
     * @return -2 password不符合规范
     * @return -3 userName不符合规范
     * @return -4 admin被注册
     * @return 1  注册成功
     *
     */
    @Override
    public int register(User user) {
        Pattern pattern=Pattern.compile("[A-z0-9]{6,10}");
        Matcher matcher=pattern.matcher(user.getAdmin());

        if (!matcher.matches()){
            System.out.println("admin不符合规范");
            return -1;
        }
        pattern=Pattern.compile("[A-z0-9!@#$%^&*]{6,10}");
        matcher=pattern.matcher(user.getPassword());
        if (!matcher.matches()){
            System.out.println("password不符合规范");
            return -2;
        }
        pattern=Pattern.compile("[A-z0-9]{3,8}");
        matcher=pattern.matcher(user.getUserName());
        if(!matcher.matches()){
            System.out.println("userName不符合规范");
            return -3;
        }
        User user1=userMapper.selectByName(user.getAdmin());
        //判断用户名是否被注册
        if (user1!=null){
            return -4;
        }

        userMapper.insertUser(user.getAdmin(),user.getPassword(),user.getUserName());
        System.out.println("注册成功！");
        return 1;
    }

    /**
     * 用户登录
     * @param admin
     * @param password
     * @return
     */
    @Override
    public User login(String admin, String password) {
        User user=userMapper.selectUser(admin,password);
        if (user!=null){
            return user;
        }
        return null;
    }
}
