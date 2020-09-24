package com.xmz.test;

import com.xmz.dao.IManagerDao;
import com.xmz.domain.Manager;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class ManagerTest {

    InputStream in;
    SqlSession sqlSession;
    IManagerDao managerDao;

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession(true);
        managerDao = sqlSession.getMapper(IManagerDao.class);
    }

    @After
    public void destroy() throws Exception{
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll(){
        List<Manager> managerList = managerDao.findAll();
        for(Manager manager:managerList){
            System.out.println(manager);
        }
    }

    @Test
    public void testFindById(){
        List<Manager> managerList = managerDao.findById(1);
        for(Manager manager:managerList){
            System.out.println(manager);
        }
    }

    @Test
    public void testFindByName(){
        List<Manager> managerList = managerDao.findByName("%1%");
        for(Manager manager:managerList){
            System.out.println(manager);
        }
    }

    @Test
    public void testSaveManager(){
        Manager m = new Manager();
        m.setName("777");
        m.setPassword("777");
        managerDao.saveManager(m);
        System.out.println(m);
    }

    @Test
    public void testUpdateManager(){
        Manager m = new Manager();
        m.setName("777");
        m.setPassword("777");
        managerDao.updateManager(m);
        System.out.println(m);
    }

    @Test
    public void testDeleteManager(){
        managerDao.delete(7);
    }

    @Test
    public void testTotal(){
        int total = managerDao.findTotal();
        System.out.println(total);
    }
}
