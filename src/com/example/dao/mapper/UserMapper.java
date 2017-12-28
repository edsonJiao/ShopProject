package com.example.dao.mapper;

import com.example.pojo.Goods;
import com.example.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
@Qualifier(value = "userMapper")
public interface UserMapper {

    //用户登录
    User selectUser(@Param("admin") String admin, @Param("password") String password);

    //用户注册
    void insertUser(@Param("admin") String admin,@Param("password") String password,@Param("username") String username);

    //查询用户名
    User selectByName(@Param("name") String name);

    //查询商品列表
    List<Goods> selectGoods();

    //通过商品名称关键字实现模糊查询
    List<Goods> selectGoodsByName(String name);
}
