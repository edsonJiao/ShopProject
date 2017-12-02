package test;

import com.example.Utils.SpringUtils;
import com.example.dao.mapper.UserMapper;
import com.example.pojo.Goods;
import com.example.pojo.User;
import com.example.service.UserBuyService;
import com.example.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

//单元测试类
public class UserTest {
private ApplicationContext context;
    @Before
    public void before(){
        context=new ClassPathXmlApplicationContext("SpringConfig.xml");
    }

    /**
     * @Test
     * @author edsonJiao
     * 测试User插入
     */
    @Test
    public void testInsert(){
        UserMapper userMapper= (UserMapper) context.getBean("userMapper");
        userMapper.insertUser("edson123","123456","edsonjiao");
    }

    @Test
    public void testDelete(){

    }

    @Test
    public void testUpdate(){

    }

    /**
     * @Test
     * @author edsonJiao
     * 测试User查询
     */
    @Test
    public void testSelect(){
        UserMapper userMapper= (UserMapper) context.getBean("userMapper");
        User user=userMapper.selectUser("edson123","123456");
        if (user!=null){
            System.out.println(user.getUserName()+"  "+user.getAdmin()+" "+user.getPassword());
        }else {
            System.out.println("用户不存在");
        }
    }


    @Test
    public void testSelectGoodsByName(){
        UserMapper userMapper= (UserMapper) context.getBean("userMapper");
        List<Goods> goodsList=userMapper.selectGoodsByName("mac");
        for (Goods goods:goodsList){
            System.out.println(goods.getGoodName());
        }
    }
    /**
     * 测试用户购买以及更新库存功能
     * @Test
     *
     */
    @Test
    public void testBuy(){
        UserBuyService userBuyService= (UserBuyService) context.getBean("UserBuyServiceImpl");
        double cost=userBuyService.buy(3,1);
        System.out.println(cost);
    }

    /**
     * 测试添加到购物车功能
     * @Test
     */
    @Test
    public void testAddToCar(){
        UserBuyService userBuyService= (UserBuyService) context.getBean("UserBuyServiceImpl");
        UserService userService=(UserService)context.getBean("UserServiceImpl");
        User user=userService.login("edson123","654321");
        userBuyService.addToCar(user,"thinkpad",1);
        userBuyService.addToCar(user,"macbookpro",1);
        Map map=user.getShoppingCar().getGoodMap();
        Set<String> keySet=map.keySet();

        for (String s:keySet){
            System.out.println(s+"="+map.get(s));
        }
        System.out.println(userBuyService.payFromCar(user));
    }
    @After
    public void after(){

    }
}
