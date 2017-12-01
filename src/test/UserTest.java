package test;

import com.example.dao.mapper.UserMapper;
import com.example.pojo.Goods;
import com.example.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

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
    @After
    public void after(){

    }
}
