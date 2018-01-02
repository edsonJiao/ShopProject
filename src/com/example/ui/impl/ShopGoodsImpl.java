package com.example.ui.impl;

import com.example.ui.ShopGoods;
import com.example.util.SpringUtils;
import com.example.pojo.Goods;
import com.example.service.UserBuyService;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ShopGoodsImpl implements ShopGoods{
    private ApplicationContext context= SpringUtils.getContext();
    private UserBuyService userBuyService= (UserBuyService) context.getBean("UserBuyServiceImpl");
    private static int i=0;
    /**
     * @Todo7
     * 商场商品UI
     */
    @Override
    public void operator() {
        List<Goods> goodsList=userBuyService.listAllGoods();
        JFrame jFrame = new JFrame();
        jFrame.setTitle("商品列表");
        jFrame.setSize(600,600);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setLayout(null);
        //下一个按钮
        JButton nextButton=new JButton("下一个");
        //当没有下一个物品时，下一个按钮不存在
        if (i<goodsList.size()-1) {
            nextButton.setBounds(480, 540, 100, 20);
            jFrame.add(nextButton);
        }
        //上一个按钮
        JButton lastButton=new JButton("上一个");
        //当没有上一个物品时，不显示上一个按钮
        if (i>0){
            lastButton.setBounds(20,540,100,20);
            jFrame.add(lastButton);
        }
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                new MainPageImpl().show();
            }
        });
        for (Goods goods:goodsList){
            FileOutputStream outputStream= null;
            try {
                outputStream = new FileOutputStream("images/"+goods.getGoodName()+".jpg");
                outputStream.write(goods.getPicture());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

            JLabel imageLabel = new JLabel(new ImageIcon("images/" + goodsList.get(i).getGoodName() + ".jpg"));
            imageLabel.setBounds(100, 0, 400, 400);
            jFrame.add(imageLabel);
            JLabel goodNameLabel = new JLabel("商品名称:" + goodsList.get(i).getGoodName());
            goodNameLabel.setBounds(220, 380, 150, 100);
            jFrame.add(goodNameLabel);
            JLabel goodIdLabel = new JLabel("商品id:" + goodsList.get(i).getId());
            goodIdLabel.setBounds(220,410,150,100);
            jFrame.add(goodIdLabel);
            JLabel goodPriceLabel = new JLabel("商品单价:" + goodsList.get(i).getPrice());
            goodPriceLabel.setBounds(220,440,150,100);
            jFrame.add(goodPriceLabel);
            JLabel goodAccountLabel = new JLabel("商品库存:" + goodsList.get(i).getAccount());
            goodAccountLabel.setBounds(220,470,150,100);
            jFrame.add(goodAccountLabel);
                nextButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jFrame.dispose();
                        i++;
                        new ShopGoodsImpl().operator();
                    }
                });

                lastButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jFrame.dispose();
                        i--;
                        new ShopGoodsImpl().operator();
                    }
                });
                JButton buyButton=new JButton("购买");
                buyButton.setBounds(230,540,100,20);
                jFrame.add(buyButton);
                buyButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String inputValue = JOptionPane.showInputDialog("请输入购买的数量");
                        int number=Integer.parseInt(inputValue);
                        userBuyService.buy(goodsList.get(i).getId(),number);
                        jFrame.dispose();
                        new ShopGoodsImpl().operator();
                    }
                });
    }
}
