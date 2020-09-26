package com.xmz.ui;

import com.xmz.dao.IAccountDao;
import com.xmz.factory.BeanFactory;
import com.xmz.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client1 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean2.xml");
        IAccountService as = (IAccountService) ac.getBean("accountServiceImpl3");//没有value，即默认，首字母改小写
        as.saveAccount();
        IAccountDao accountDao = ac.getBean("accountDao1", IAccountDao.class);
        System.out.println(as);
        System.out.println(accountDao);
    }
}
