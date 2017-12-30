package com.example.dao.mapper;

import com.example.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Repository;

import java.util.List;
@Repository(value = "adminMapper")
public interface AdminMapper {
    //增加商品
    void insertGoods(@Param("goodName") String goodName, @Param("account") int account,
                     @Param("price") double price, @Param("picture") byte[] picture);

    //删除商品
    void deleteGoods(@Param("id") int id);

    //更改商品
    void updateGoods(@Param("id") int id,@Param("goodName") String goodName,
                     @Param("account") int account,@Param("price") double price);

    //更改商品的图片
    void updateGoodPicture(@Param("id") int id,@Param("price") byte[] picture);

    //查询所有商品
    List<Goods> selectGoods();
}
