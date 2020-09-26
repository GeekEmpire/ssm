package com.xmz.dao.impl;

import com.xmz.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository(value = "accountDao2")
public class AccountDaoImpl2 implements IAccountDao {

    public void saveAccount() {
        System.out.println("save over2");
    }
}
