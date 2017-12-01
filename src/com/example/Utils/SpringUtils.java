package com.example.Utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 用于获取Spring配置文件的工具类
 */
public class SpringUtils {
    private static ApplicationContext context=new ClassPathXmlApplicationContext("SpringConfig.xml");

    public static ApplicationContext getContext(){
        return context;
    }
}
