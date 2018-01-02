package com.example.ui.impl;

import com.example.ui.MainPage;
import com.example.ui.RootLogin;
import com.example.ui.UserLogin;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import static javax.swing.JFrame.EXIT_ON_CLOSE;

//编写主页UI
public class MainPageImpl implements MainPage{
    /**
     * @TODO1
     * 主页面UI
     */
    JFrame mainPage = new JFrame("主菜单");
    @Override
    public void show()  {

        mainPage.setSize(300,400);
        mainPage.setLocationRelativeTo(null);
        mainPage.setVisible(true);
        mainPage.setResizable(false);
        mainPage.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainPage.setLayout(null);
//        mainPage.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent windowEvent) {
//                System.exit(0);
//            }
//        });

        //管理员登录
        JButton adminLoginButton = new JButton("管理员登录");
        adminLoginButton.setSize(100,30);
        adminLoginButton.setLocation(90,80);
        mainPage.add(adminLoginButton);
        adminLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                RootLogin rootLogin = new RootLoginImpl();
                rootLogin.login();
                mainPage.dispose();
            }
        });

        //普通用户登录
        JButton userLoginButton = new JButton("用户登录");
        userLoginButton.setSize(100,30);
        userLoginButton.setLocation(90,150);
        mainPage.add(userLoginButton);
        userLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                UserLogin userLogin = new UserLoginImpl();
                userLogin.login();
            }
        });

        //用户注册
        JButton registerButton = new JButton("用户注册");
        registerButton.setSize(100,30);
        registerButton.setLocation(90,220);
        mainPage.add(registerButton);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                UserLogin userLogin = new UserLoginImpl();
                userLogin.register();
            }
        });
    }
}
