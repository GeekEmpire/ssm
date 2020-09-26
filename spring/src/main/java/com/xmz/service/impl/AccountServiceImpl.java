package com.xmz.service.impl;

import com.xmz.dao.IAccountDao;
import com.xmz.dao.impl.AccountDaoImpl;
import com.xmz.factory.BeanFactory;
import com.xmz.service.IAccountService;

import java.util.Date;

public class AccountServiceImpl implements IAccountService {

    //经常变动的数据不适合注入的方式
    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl(String name, Integer age, Date birthday){
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }
//    IAccountDao accountDao = new AccountDaoImpl();
//    IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");
//    int i=0;

//    public void saveAccount() {
//        accountDao.saveAccount();
//        i++;
//        System.out.println(i);
//    }
    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了"+this.name+this.age+this.birthday);
    }

    public void init(){
        System.out.println("service 对象初始化了");
    }

    public void destroy(){
        System.out.println("service 对象销毁了");
    }
}
