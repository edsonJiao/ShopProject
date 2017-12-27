package com.example.pojo;

import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 管理员类
 *
 * 用于对数据库中Goods表进行操作
 * 为了安全起见，管理员帐号密码的更改不会设置在程序中
 * 而是记录在数据库中
 * 若要修改Root的帐号密码在数据库中进行修改
 *
 * 优化：因为Root管理员只有一个，考虑能否设计成单例模式
 */
@Qualifier("root")
public class Root {
    private String admin;
    private String password;

    public Root(){}

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
}
