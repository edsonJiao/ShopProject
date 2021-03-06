package com.example.dao.mapper;

import com.example.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
@Repository(value = "goodsResetUpdate")
public interface GoodsResetUpdate {
    //查询单个商品
    Goods getSingle(@Param("id") int id);

    //通过名称查询到商品
    Goods getSingleByName(@Param("name") String name);

    //更新商品的库存
    void updateReset(@Param("id") int id,@Param("count") int count);
}
