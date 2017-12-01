package test;

import com.example.pojo.User;
import com.example.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//Userservice用户登录注册测试类
public class UserServiceTest {
    private ApplicationContext context;
    @Before
    public void before(){
        context=new ClassPathXmlApplicationContext("SpringConfig.xml");
    }
    @Test
    public void testRegister(){
        User user=new User();
        user.setAdmin("jack123");
        user.setPassword("123456!");
        user.setUserName("jack");
        UserService userService= (UserService) context.getBean("UserServiceImpl");
        boolean b=userService.register(user);
        System.out.println(b);
    }
    @Test
    public void testLogin(){
        UserService userService= (UserService) context.getBean("UserServiceImpl");
        User user=userService.login("edson123","654321");
        if(user!=null){
            System.out.println(user.getUserName());
        }else {
            System.out.println("帐号或密码错误");
        }
    }
}
