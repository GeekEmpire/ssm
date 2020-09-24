package com.xmz.test;

import com.xmz.dao.IRoleDao;
import com.xmz.dao.IRoleUserDao;
import com.xmz.domain.Role;
import com.xmz.domain.RoleUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class RoleUserTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IRoleUserDao roleUserDao;

    @Before//用于在测试方法执行之前执行
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //设置自动提交commit
        sqlSession = factory.openSession(true);
        //sqlSession = factory.openSession();
        roleUserDao = sqlSession.getMapper(IRoleUserDao.class);
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

        List<RoleUser> rs = roleUserDao.findAll();
        for (RoleUser r:rs){
            System.out.println(r);
        }
    }

}
