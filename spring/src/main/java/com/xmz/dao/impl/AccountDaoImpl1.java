package com.xmz.dao.impl;

import com.xmz.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository(value = "accountDao1")
public class AccountDaoImpl1 implements IAccountDao {

    public void saveAccount() {
        System.out.println("save over1");
    }
}
