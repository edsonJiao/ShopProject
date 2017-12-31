package com.example.service.impl;

import com.example.Utils.SpringUtils;
import com.example.dao.mapper.GoodsResetUpdate;
import com.example.dao.mapper.UserMapper;
import com.example.pojo.Goods;
import com.example.pojo.User;
import com.example.service.UserBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

//用户操作类
@Service("UserBuyServiceImpl")
public class UserBuyServiceImpl implements UserBuyService{
    @Autowired
    private GoodsResetUpdate resetUpdate;
    @Autowired
    private UserMapper userMapper;
    /**
     * 根据传入的id和count购买商品
     * 如果返回值-1则说明库存不足
     * 购买成功时进行库存的更新
     * @param id
     * @param count
     * @return
     */
    @Override
    public double buy(int id, int count) {
        double cost=0;
        Goods goods=resetUpdate.selectSingle(id);
        if(goods.getAccount()<count){
            System.out.println("库存不足");
            return -1;
        }
        cost=goods.getPrice()*count;
        int reset=goods.getAccount()-count;
        resetUpdate.upDateReset(id,reset);
        return cost;
    }

    @Override
    public void addToCar(User user,String goodName, int count) {
        Map goodMap=user.getShoppingCar().getGoodMap();
        goodMap.put(goodName,count);
    }

    /**
     * 购物车中付款
     * 涉及到更新库存，清空购物车，动态sql
     * @param user
     */
    @Override
    public double payFromCar(User user) {
        double totalCost=0;
        Map<String,Integer> carMap=user.getShoppingCar().getGoodMap();

        Set<String> keySet=carMap.keySet();
        for (String key:keySet){
            Goods goods=resetUpdate.selectSingleByName(key);
            int value=carMap.get(key);
            totalCost=totalCost+this.buy(goods.getId(),value);
        }

        //清空购物车
        carMap.clear();
        return totalCost;
    }

    @Override
    public List<Goods> showAllGoods() {
        List<Goods> list= userMapper.selectGoods();
        return list;
    }
}
