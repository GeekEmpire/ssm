package com.xmz.test;

import com.xmz.dao.IAccountDao;
import com.xmz.dao.IUserDao;
import com.xmz.domain.Account;
import com.xmz.domain.AccountUser;
import com.xmz.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class AccountTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IAccountDao accountDao;

    @Before//用于在测试方法执行之前执行
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //设置自动提交commit
        sqlSession = factory.openSession(true);
        //sqlSession = factory.openSession();
        accountDao = sqlSession.getMapper(IAccountDao.class);
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

        List<Account> accounts = accountDao.findAll();
//        for (Account account:accounts){
//            System.out.println(account);
//        }
    }


    /**
     * 测试查询所有账户包括名称和地址
     * @throws Exception
     */
    @Test
    public void testFindAllAccountUser() throws Exception{

        List<AccountUser> aus = accountDao.findAllAccount();
        for (AccountUser au:aus){
            System.out.println(au);
        }
    }
}
