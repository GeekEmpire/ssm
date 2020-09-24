package com.xmz.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 一个Bean对象的工厂
 * Bean：可重用组件
 * JavaBean：不等于实体类，》实体类，用java编写的可重用组件
 */
public class BeanFactory {
    private static Properties properties;

    private static Map<String, Object> beans;

    static {
        try{
            properties = new Properties();
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            properties.load(in);
            beans = new HashMap<String, Object>();
            Enumeration keys = properties.keys();
            while (keys.hasMoreElements()){
                String key = keys.nextElement().toString();
                String beanPath = properties.getProperty(key);
                Object value = Class.forName(beanPath).newInstance();
                beans.put(key, value);
            }
        } catch (Exception e){
            throw new ExceptionInInitializerError("初始化properties失败！");
        }
    }

    public static Object getBean(String beanName) {//单例
        return beans.get(beanName);
    }

//    public static Object getBean(String beanName) {   //多例
//        Object bean = null;
//        try {
//            String beanPath = properties.getProperty(beanName);
//            System.out.println(beanPath);
//            bean = Class.forName(beanPath).newInstance();//按默认构造函数创建对象
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return bean;
//    }
}
