package com.xmz.dao;

import com.xmz.domain.Account;
import com.xmz.domain.AccountUser;

import java.util.List;

public interface IAccountDao {

    List<Account> findAll();

    List<Account> findAccountById(Integer uid);

    List<AccountUser> findAllAccount();
}
