package com.example.dao.mapper;

import com.example.pojo.Goods;

import java.util.List;

public interface AdminMapper {
    //增加商品
    void insertGoods(String goodName,int account,double price,byte[] picture);

    //删除商品
    void deleteGoods(int id);

    //更改商品
    void updateGoods(int id,String goodName,int account,double price);

    //更改商品的图片
    void updateGoodPicture(int id,byte[] picture);

    //查询所有商品
    List<Goods> selectGoods();
}
