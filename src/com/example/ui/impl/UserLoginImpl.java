package com.example.ui.impl;

import com.example.ui.UserLogin;
import com.example.util.SpringUtils;
import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//编写用户注册和登录UI
public class UserLoginImpl implements UserLogin {
    private ApplicationContext context= SpringUtils.getContext();
    private UserService userService= (UserService) context.getBean("UserServiceImpl");
    /**
     * @Todo2
     * 用户登录UI
     */
    @Override
    public void login() {
        JFrame jFrame = new JFrame();
        jFrame.setTitle("用户登陆");
        jFrame.setSize(300,300);
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

        JLabel admin = new JLabel("帐号:");
        admin.setBounds(50,30,100,30);
        jFrame.add(admin);

        JLabel password = new JLabel("密码:");
        password.setBounds(50,70,100,30);
        jFrame.add(password);

//        JLabel checkCode=new JLabel("验证码");
//        checkCode.setBounds(50,110,100,30);
//        jFrame.add(checkCode);

        JTextField adminText = new JTextField();
        adminText.setBounds(150,30,100,30);
        jFrame.add(adminText);

        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(150,70,100,30);
        jFrame.add(passwordText);
//
//        JTextField checkCodeText=new JTextField();
//        checkCodeText.setBounds(150,110,100,30);
//        jFrame.add(checkCodeText);

        //验证码图片设置在按钮背景上
//         JButton checkCodePic=new JButton("");
//         String checkCodeValude = VerificationCode.createVerification();

//
//        ImageIcon icon = new ImageIcon("images/verification.jpg");
//        checkCodePic.setIcon(icon);
//        checkCodePic.setBounds(150,140,100,30);
//        jFrame.add(checkCodePic);
//
        JButton login = new JButton("登录");
        login.setBounds(60,180,70,30);
        jFrame.add(login);
//        //更改验证码图片
//        checkCodePic.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                new UserLoginImpl().login();
//                ImageIcon icon = new ImageIcon("images/verification.jpg");
//                checkCodePic.setIcon(icon);
//                checkCodePic.setBounds(150,140,100,30);
//                jFrame.add(checkCodePic);
//
//            }
//        });
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String admin = adminText.getText();
                String password = passwordText.getText();
                System.out.println(admin + "    " + password);
                User user = userService.login(admin, password);
                if (user != null) {
                    jFrame.dispose();
                    new ShopGoodsImpl().operator();
                } else {
                    JOptionPane.showMessageDialog(null, "密码错误", "警告", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton cancel = new JButton("返回");
        cancel.setBounds(160,180,70,30);
        jFrame.add(cancel);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jFrame.dispose();
                new MainPageImpl().show();

            }
        });
    }



    /**
     * @Todo3
     * 用户注册
     */
    @Override
    public void register() {
        JFrame jFrame = new JFrame();
        jFrame.setTitle("用户注册");
        jFrame.setSize(300,300);
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

        JLabel admin = new JLabel("帐号:");
        admin.setBounds(50,30,100,30);
        jFrame.add(admin);

        JLabel password = new JLabel("密码:");
        password.setBounds(50,70,100,30);
        jFrame.add(password);

        JLabel rePassword=new JLabel("重复密码:");
        rePassword.setBounds(50,110,100,30);
        jFrame.add(rePassword);

        JLabel nickName=new JLabel("昵称:");
        nickName.setBounds(50,150,100,30);
        jFrame.add(nickName);



        JTextField adminText = new JTextField();
        adminText.setBounds(150,30,100,30);
        jFrame.add(adminText);

        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(150,70,100,30);
        jFrame.add(passwordText);

        JPasswordField rePasswordText=new JPasswordField();
        rePasswordText.setBounds(150,110,100,30);
        jFrame.add(rePasswordText);

        JTextField nickNameText=new JTextField();
        nickNameText.setBounds(150,150,100,30);
        jFrame.add(nickNameText);

        JButton registeButton = new JButton("注册");
        registeButton.setBounds(120,200,70,30);
        jFrame.add(registeButton);
        //注册按钮点击事件
        registeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String admin=adminText.getText();
                String password=passwordText.getText();
                String rePassword=rePasswordText.getText();
                String nickName=nickNameText.getText();
                System.out.println(password);
                System.out.println(rePassword);
                if (!password.equals(rePassword)){
                    JOptionPane.showMessageDialog(null, "两次密码输入不一致", "警告", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                User user=new User();
                user.setAdmin(admin);
                user.setPassword(password);
                user.setUserName(nickName);
                int resultCode=userService.register(user);
                if (resultCode==-4){
                    JOptionPane.showMessageDialog(null,"用户名已注册","警告",JOptionPane.ERROR_MESSAGE);
                    return;
                }else if (resultCode==-1){
                    JOptionPane.showMessageDialog(null, "用户名只能为6到10位大小写字母或数字", "警告", JOptionPane.ERROR_MESSAGE);
                    return;
                }else if (resultCode==-2){
                    JOptionPane.showMessageDialog(null,"密码只能为6-10位大小写字母、数字和简单字符","警告",JOptionPane.ERROR_MESSAGE);
                    return;
                }else if (resultCode==-3){
                    JOptionPane.showMessageDialog(null,"昵称只能为3-8位大小写字母及数字","警告",JOptionPane.ERROR_MESSAGE);
                    return;
                }

                JOptionPane.showMessageDialog(null,"注册成功","成功",JOptionPane.PLAIN_MESSAGE);

            }
        });
    }
}

