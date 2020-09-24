package com.xmz.service.impl;

import com.xmz.dao.IAccountDao;
import com.xmz.dao.impl.AccountDaoImpl;
import com.xmz.factory.BeanFactory;
import com.xmz.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

//    IAccountDao accountDao = new AccountDaoImpl();
    IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");
    int i=0;

    public void saveAccount() {
        accountDao.saveAccount();
        i++;
        System.out.println(i);
    }
}
