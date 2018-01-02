package com.example.service;

import com.example.pojo.Goods;
import com.example.pojo.User;

import java.util.List;

public interface UserBuyService {
    //用户购买商品
    double buy(int id,int count);

    //添加至购物车
    void addToCar(User user,String goodName, int count);

    //付款并且清空购物车
    double payFromCar(User user);

    //显示商品
    List<Goods> listAllGoods();
}
