package test;

import com.example.util.SpringUtils;
import com.example.dao.mapper.RootMapper;
import com.example.pojo.Root;
import com.example.service.RootLoginService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class RootTest {
    ApplicationContext context= SpringUtils.getContext();
    @Autowired
    private RootLoginService rootLoginService;
    @Autowired
    private RootMapper rootMapper;
    @Test
    public void testLogin(){
        RootLoginService rootLoginService= (RootLoginService) context.getBean("rootLoginService");
        Root root=rootLoginService.login("admin23","123456");
        if (root!=null){
            System.out.println("登录成功！");
        }else {
            System.out.println("登录失败！");
        }
    }
    @Test
    public void testRootLogin(){
//        rootLoginService.login("sdas","adas");
//        rootMapper.login("adas","dasd");
    }
}
