package test;

import com.example.Utils.PictureUtils;
import com.example.Utils.SpringUtils;
import com.example.dao.mapper.AdminMapper;
import com.example.service.RootService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

public class RootServiceTest {
    private ApplicationContext applicationContext= SpringUtils.getContext();
    @Test
    public void testAddGoods(){
        String goodName="thinkpad";
        int account=100;
        double price=8999.9;
        byte[] picture= PictureUtils.getPicture("images/thinkpad.jpg");
//        Goods goods=new Goods(goodName,account,price,picture);
        RootService rootService= (RootService) applicationContext.getBean("RootServiceImpl");
//        adminMapper.insertGoods(goodName,account,price,picture);
        rootService.addGoods(goodName,account,price,picture);
    }
    @Test
    public void testDeleteGood(){
        RootService rootService= (RootService) applicationContext.getBean("RootServiceImpl");
        rootService.deleteGoods(5);
    }
}
