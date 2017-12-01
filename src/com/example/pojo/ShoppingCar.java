package com.example.pojo;

import java.util.HashMap;
import java.util.Map;

/**
 * 购物车类
 *
 * 属性
 * userId 用户ID
 * goodMap 存储的商品名称和数量
 */
public class ShoppingCar {
    private int userId;
    private Map goodMap=new HashMap<String,Integer>();

    public ShoppingCar(){}

    public ShoppingCar(int userId){
        this.userId=userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Map getGoodMap() {
        return goodMap;
    }

}
