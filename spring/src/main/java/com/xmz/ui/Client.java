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
     *  ApplicationContext的三个常用实现类              实际开发更多使用这种方法
     *      ClassPathXmlApplicationContext：能且仅能加载类路径下的配置文件
     *      FileSystemXmlApplicationContext: 可以加载磁盘任意路径的配置文件（需要有访问权限)
     *      AnnotationConfigApplicationContext: 用于读取注解创建容器
     *读取完配置文件立即创建配置文件中的对象           单例对象适用
     *
     * BeanFactory:构建核心容器时，创建对象采取的策略是延迟加载，根据id获取具体对象时，创建对象
     *          多例对象适用
     * @param args
     */
    public static void main(String[] args) {
//        ApplicationContext ac = new FileSystemXmlApplicationContext("磁盘具体路径");
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        IAccountService as = (IAccountService) ac.getBean("accountService");

//        IAccountService as = (IAccountService) ac.getBean("accountService1");

        IAccountService as = (IAccountService) ac.getBean("accountService2");

        as.saveAccount();
//        IAccountDao adao = ac.getBean("accountDao", IAccountDao.class);

        System.out.println(as);
//        System.out.println(adao);
    }
}
