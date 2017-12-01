package com.example.service;

import com.example.pojo.Goods;

public interface RootService {

    //添加商品
    void addGoods(String goodName,int account,double price,byte[] picture);

    //删除商品
    void deleteGoods(int id);

    //更改商品信息
    void updateGoods(int id,String goodName,int account,double price);

    //更改商品图片
    void updateGoodPicture(int id,byte[] picture);
}
