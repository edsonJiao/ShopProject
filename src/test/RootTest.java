package test;

import com.example.Utils.SpringUtils;
import com.example.dao.mapper.RootMapper;
import com.example.pojo.Root;
import com.example.service.RootLoginService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

public class RootTest {
    ApplicationContext context= SpringUtils.getContext();
    @Test
    public void testLogin(){
        RootLoginService rootLoginService= (RootLoginService) context.getBean("RootLoginServiceImpl");
        Root root=rootLoginService.login("admin123","123456");
        if (root!=null){
            System.out.println("登录成功！");
        }else {
            System.out.println("登录失败！");
        }
    }
}
