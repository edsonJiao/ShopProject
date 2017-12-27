package com.example.UI.impl;

import com.example.UI.RootOperate;
import com.example.UI.UserLogin;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

//管理员操作UI
public class RootOperateImpl implements RootOperate {
    /**
     * @Todo5
     * 管理员操作UI
     */
    @Override
    public void operator() {
        JFrame op = new JFrame("管理员操作");
        op.setSize(300,400);
        op.setLocationRelativeTo(null);
        op.setVisible(true);
        op.setResizable(false);
        op.setLayout(null);

        op.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                new MainPageImpl().show();
            }
        });
        JButton addGoods = new JButton("添加商品");
        addGoods.setSize(100,30);
        addGoods.setLocation(90,60);
        op.add(addGoods);
        addGoods.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                op.dispose();
                new AddGoods().add();
            }
        });

    }
}

class AddGoods{
    void add(){
        JFrame addFrame = new JFrame("添加商品");
        addFrame.setSize(300,400);
        addFrame.setLocationRelativeTo(null);
        addFrame.setVisible(true);
        addFrame.setResizable(false);
        addFrame.setLayout(null);
        addFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                new RootOperateImpl().operator();
            }
        });
        JLabel goodName = new JLabel("商品名称");
        goodName.setBounds(50,50,120,50);
        addFrame.add(goodName);

        JLabel goodNum = new JLabel("商品数量");
        goodNum.setBounds(50,120,120,50);
        addFrame.add(goodNum);

        JLabel goodPrice = new JLabel("商品价格");
        goodPrice.setBounds(50,190,120,50);
        addFrame.add(goodPrice);

        JTextField goodNameText = new JTextField();
        goodNameText.setBounds(130,60,120,30);
        addFrame.add(goodNameText);

        JTextField goodNumText = new JTextField();
        goodNumText.setBounds(130,130,120,30);
        addFrame.add(goodNumText);

        JTextField goodPriceText = new JTextField();
        goodPriceText.setBounds(130,200,120,30);
        addFrame.add(goodPriceText);

        JButton add = new JButton("添加");
        add.setBounds(60,300,70,30);
        addFrame.add(add);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        JButton cancel = new JButton("返回");
        cancel.setBounds(170,300,70,30);
        addFrame.add(cancel);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addFrame.dispose();
                new RootOperateImpl().operator();
            }
        });
    }


}
