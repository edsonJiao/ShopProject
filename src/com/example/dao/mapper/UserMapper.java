package com.example.dao.mapper;

import com.example.pojo.Goods;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public interface UserMapper {

    //用户登录
    User selectUser(String admin,String password);

    //用户注册
    void insertUser(String admin,String password,String username);

    //查询用户名
    User selectByName(String name);

    //查询商品列表
    List<Goods> selectGoods();

    //通过商品名称关键字实现模糊查询
    List<Goods> selectGoodsByName(String name);
}
