package com.xmz.ui;

import com.xmz.dao.IAccountDao;
import com.xmz.factory.BeanFactory;
import com.xmz.service.IAccountService;
import com.xmz.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Client {

    /**
     * 获取spring的ioc核心容器，并根据id获取对象
     *  ApplicationContext的三个常用实现类
     *      ClassPathXmlApplicationContext：能且仅能加载类路径下的配置文件
     *      FileSystemXmlApplicationContext: 可以加载磁盘任意路径的配置文件（需要有访问权限)
     *      AnnotationConfigApplicationContext: 用于读取注解创建容器
     * @param args
     */
    public static void main(String[] args) {
//        ApplicationContext ac = new FileSystemXmlApplicationContext("磁盘具体路径");
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as = (IAccountService) ac.getBean("accountService");
        IAccountDao adao = ac.getBean("accountDao", IAccountDao.class);

        System.out.println(as);
        System.out.println(adao);
    }
}
