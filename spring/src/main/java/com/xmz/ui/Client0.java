package com.xmz.ui;

import com.xmz.factory.BeanFactory;
import com.xmz.service.IAccountService;

public class Client0 {
    public static void main(String[] args) {
//        IAccountService as = new AccountServiceImpl();
        for(int i=0;i<5;i++){
            IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
            as.saveAccount();
            System.out.println(as);
        }
    }
}
