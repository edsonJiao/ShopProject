package com.example.dao.mapper;

import com.example.pojo.Goods;
import com.example.pojo.User;
import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Repository;


import java.util.List;
@Repository(value = "userMapper")
public interface UserMapper {

    //用户登录
    User getUser(@Param("admin") String admin, @Param("password") String password);

    //用户注册
    void insertUser(@Param("admin") String admin,@Param("password") String password,@Param("username") String username);

    //查询用户名
    User getByName(@Param("name") String name);

    //查询商品列表
    List<Goods> listAllGoods();

    //通过商品名称关键字实现模糊查询
    List<Goods> listAllGoodsByName(String name);
}
