package com.example.pojo;

import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 商品属性类
 * 属性：id 商品名称 单价 数量 商品图片
 */
@Qualifier("goods")
public class Goods {
    private int id;
    private String goodName;
    private int account;
    private double price;
    private byte[] picture;

    public Goods(){}

    public Goods(String goodName, int account, double price, byte[] picture) {
        this.goodName = goodName;
        this.account = account;
        this.price = price;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}
