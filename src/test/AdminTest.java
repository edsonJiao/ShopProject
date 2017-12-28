package test;

import com.example.Utils.PictureUtils;
import com.example.dao.mapper.AdminMapper;
import com.example.pojo.Goods;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

//管理员功能测试类
public class AdminTest {
    private ApplicationContext context;
    @Before
    public void before(){
        context=new ClassPathXmlApplicationContext("SpringConfig.xml");
    }
    @Test
    public void testInsertGoods(){
        AdminMapper adminMapper= (AdminMapper) context.getBean("adminMapper");
        String goodName="macbookpro";
        int account=10;
        double price=9999.9;
        byte[] picture= PictureUtils.getPicture("images/macbookpro.jpg");
        adminMapper.insertGoods(goodName,account,price,picture);
    }
    @Test
    public void testDeleteGoodById(){
        AdminMapper adminMapper= (AdminMapper) context.getBean("adminMapper");
        adminMapper.deleteGoods(5);
    }
    @Test
    public void testSelectGoods(){
        AdminMapper adminMapper= (AdminMapper) context.getBean("adminMapper");
        List<Goods> goodsList=adminMapper.selectGoods();
        for (Goods goods:goodsList){
            System.out.println(goods.getGoodName());
        }
    }
    @Test
    public void testUpdateGood(){
        AdminMapper adminMapper= (AdminMapper) context.getBean("adminMapper");
        adminMapper.updateGoods(2,"macbookair",10,5999.9);
    }
}
