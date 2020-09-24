package com.xmz.test;

import com.xmz.dao.IAccountDao;
import com.xmz.dao.IAccountDao2;
import com.xmz.domain.Account;
import com.xmz.domain.AccountUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class AccountTest2 {
    private InputStream in;
    private SqlSession sqlSession;
    private IAccountDao2 accountDao2;

    @Before//用于在测试方法执行之前执行
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //设置自动提交commit
        sqlSession = factory.openSession(true);
        //sqlSession = factory.openSession();
        accountDao2 = sqlSession.getMapper(IAccountDao2.class);
    }

    @After//用于在测试方法执行之后执行
    public void destroy() throws Exception{
        //sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    /**
     * 测试查询所有
     * @throws Exception
     */
    @Test
    public void testFindAll() throws Exception{
        List<Account> accounts = accountDao2.findAll();
        for (Account account:accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindById() throws Exception{
        List<Account> accounts = accountDao2.findAccountByUid(1);
        for (Account account:accounts){
            System.out.println(account);
        }
    }
}
