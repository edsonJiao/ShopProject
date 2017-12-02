package com.example.service;

import com.example.pojo.User;

public interface UserBuyService {
    //用户购买商品
    double buy(int id,int count);

    //添加至购物车
    void addToCar(User user,String goodName, int count);

    //付款并且清空购物车
    void payFromCar(User user);
}
