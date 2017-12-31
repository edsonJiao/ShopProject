package com.example.pojo;

import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 普通用户类
 * 属性：
 * id admin password userName shoppingCar
 */
@Qualifier(value = "user")
public class User {
    private int id;
    private String admin;
    private String password;
    private String userName;
    private ShoppingCar shoppingCar=new ShoppingCar(this.getId());

    public User(){}



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ShoppingCar getShoppingCar() {
        return shoppingCar;
    }

    public void setShoppingCar(ShoppingCar shoppingCar) {
        this.shoppingCar = shoppingCar;
    }
}
