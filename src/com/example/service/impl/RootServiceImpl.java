package com.example.service.impl;

import com.example.Utils.SpringUtils;
import com.example.dao.mapper.AdminMapper;
import com.example.pojo.Goods;
import com.example.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

//管理员操作类
@Service("RootServiceImpl")
public class RootServiceImpl implements RootService{
    @Autowired
    private AdminMapper adminMapper;
    /**
     * 增加商品
     * @param goodName
     * @param account
     * @param price
     * @param picture
     */
    @Override
    public void addGoods(String goodName,int account,double price,byte[] picture) {
        adminMapper.insertGoods(goodName,account,price,picture);
    }

    /**
     * 通过id删除商品
     * @param id
     */
    @Override
    public void deleteGoods(int id) {
        adminMapper.deleteGoods(id);
    }

    /**
     * 根据id更新商品的数量、单价、名称等信息
     * @param id
     * @param goodName
     * @param account
     * @param price
     */
    @Override
    public void updateGoods(int id, String goodName, int account, double price) {
        ApplicationContext context= SpringUtils.getContext();
        AdminMapper adminMapper= (AdminMapper) context.getBean("adminMapper");
        adminMapper.updateGoods(id,goodName,account,price);
    }

    /**
     * 根据id更新商品的图片
     * @param id
     * @param picture
     */
    @Override
    public void updateGoodPicture(int id, byte[] picture) {
        ApplicationContext context= SpringUtils.getContext();
        AdminMapper adminMapper= (AdminMapper) context.getBean("adminMapper");
        adminMapper.updateGoodPicture(id,picture);
    }
}
