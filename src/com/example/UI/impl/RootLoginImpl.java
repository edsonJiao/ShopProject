package com.example.UI.impl;

import com.example.UI.MainPage;
import com.example.UI.RootLogin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//管理员用户登录
public class RootLoginImpl implements RootLogin{
    /**
     * @Todo4
     * 管理员用户登录UI
     */
    @Override
    public void login() {
        JFrame jFrame = new JFrame();
        jFrame.setTitle("管理员登陆");
        jFrame.setSize(300,200);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setLayout(null);
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                new MainPageImpl().show();
            }
        });

        JLabel admin = new JLabel("管理员账号:");

        admin.setBounds(50,30,100,30);
        jFrame.add(admin);

        JLabel password = new JLabel("管理员密码:");
        password.setBounds(50,70,100,30);
        jFrame.add(password);

        JTextField adminText = new JTextField();
        adminText.setBounds(150,30,100,30);
        jFrame.add(adminText);

        JTextField passwordText = new JTextField();
        passwordText.setBounds(150,70,100,30);
        jFrame.add(passwordText);

        JButton login = new JButton("登录");
        login.setBounds(60,120,70,30);
        jFrame.add(login);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jFrame.dispose();
                new RootOperateImpl().operator();
            }
        });

        JButton cancel = new JButton("返回");
        cancel.setBounds(160,120,70,30);
        jFrame.add(cancel);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jFrame.dispose();
                new MainPageImpl().show();
            }
        });
    }
}
