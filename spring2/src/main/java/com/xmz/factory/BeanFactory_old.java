package com.xmz.factory;

import com.xmz.domain.Account;
import com.xmz.service.IAccountService;
import com.xmz.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeanFactory_old {

    private IAccountService accountService;

    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }


    public final void setAccountService(IAccountService accountService){
        this.accountService = accountService;
    }

    public IAccountService getAccountService(){
        return (IAccountService)Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 添加事务的支持
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue = null;
                        try{
                            transactionManager.beginTransaction();
                            method.invoke(accountService, args);
                            transactionManager.commit();
                            return rtValue;
                        }catch (Exception e){
                            transactionManager.rollback();
                            throw new RuntimeException(e);
                        }finally {
                            transactionManager.release();
                        }
                    }
                });
    }
}
