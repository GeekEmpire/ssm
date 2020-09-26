package com.xmz.service.impl;

import com.xmz.dao.IAccountDao;
import com.xmz.domain.Account;
import com.xmz.service.IAccountService;
import com.xmz.utils.TransactionManager;

import java.util.List;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl_Old implements IAccountService{

    private IAccountDao accountDao;
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        try{
            transactionManager.beginTransaction();
            List<Account> accounts = accountDao.findAllAccount();
            transactionManager.rollback();
            return accounts;
        }catch (Exception e){
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            transactionManager.release();
        }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try{
            transactionManager.beginTransaction();
            Account account = accountDao.findAccountById(accountId);
            transactionManager.commit();
            return account;
        }catch (Exception e){
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            transactionManager.release();
        }
    }

    @Override
    public void saveAccount(Account account) {
        try{
            transactionManager.beginTransaction();
            accountDao.saveAccount(account);
            transactionManager.commit();
        }catch (Exception e){
            transactionManager.rollback();
        }finally {
            transactionManager.release();
        }

    }

    @Override
    public void updateAccount(Account account) {
        try{
            transactionManager.beginTransaction();
            accountDao.updateAccount(account);
            transactionManager.commit();
        }catch (Exception e){
            transactionManager.rollback();
        }finally {
            transactionManager.release();
        }

    }

    @Override
    public void deleteAccount(Integer acccountId) {
        try{
            transactionManager.beginTransaction();
            accountDao.deleteAccount(acccountId);
            transactionManager.commit();
        }catch (Exception e){
            transactionManager.rollback();
        }finally {
            transactionManager.release();
        }
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        try{
            transactionManager.beginTransaction();
            Account source = accountDao.findAccountByName(sourceName);
            Account target = accountDao.findAccountByName(targetName);
            source.setMoney(source.getMoney()-money);
//            int i = 1/0;
            target.setMoney(target.getMoney()+money);
            accountDao.updateAccount(source);
            accountDao.updateAccount(target);
            transactionManager.commit();
        }catch (Exception e){
            transactionManager.rollback();
        }finally {
            transactionManager.release();
        }

    }
}
