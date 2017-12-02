package com.example.dao.mapper;

import com.example.pojo.Goods;

public interface GoodsResetUpdate {
    //查询单个商品
    Goods selectSingle(int id);

    //通过名称查询到商品
    Goods selectSingleByName(String name);

    //更新商品的库存
    void upDateReset(int id,int count);
}
