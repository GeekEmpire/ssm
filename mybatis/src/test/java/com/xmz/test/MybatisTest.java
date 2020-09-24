package com.xmz.test;

import com.xmz.dao.IUserDao;
import com.xmz.domain.QueryVo;
import com.xmz.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 测试mybatis的操作
 */
public class MybatisTest {

    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before//用于在测试方法执行之前执行
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //设置自动提交commit
        sqlSession = factory.openSession(true);
        //sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
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

        List<User> users = userDao.findAll();
        for (User user:users){
            System.out.println(user);
        }
    }

    /**
     * 测试添加信息
     */
    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("last insertedid");
        user.setAddress("四川成都");
        user.setSex("m");
        user.setBirthday(new Date());
        System.out.println(user);
        userDao.saveUser(user);
        //插入后的user多了id值
        System.out.println(user);
    }

    /**
     * 测试修改信息
     */
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(49);
        user.setUsername("jack");
        user.setAddress("四川成都");
        user.setSex("男");
        user.setBirthday(new Date());
        userDao.updateUser(user);
    }

    /**
     * 测试删除信息
     */
    @Test
    public void testDelete(){
        Integer id = 48;
        userDao.deleteUser(id);
    }

    /**
     * 测试查询一个信息
     */
    @Test
    public void testFindOne(){
        User user = userDao.findById(49);
        System.out.println(user);
    }

    /**
     * 按username模糊查询信息
     */
    @Test
    public void testFindByName(){
        List<User> users = userDao.findByName("%王%");
        for (User user: users) {
            System.out.println(user);
        }
    }

    /**
     * 测试查询总记录数
     */
    @Test
    public void testFindTotal(){
        int total = userDao.findTotal();
        System.out.println(total);
    }

    /**
     * 按QueryVo模糊查询信息
     */
    @Test
    public void testFindByQueryVo(){
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        vo.setUser(user);
        List<User> users = userDao.findUserByVo(vo);
        for (User u: users) {
            System.out.println(u);
        }
    }

    /**
     * 按参数查询信息
     */
    @Test
    public void testFindByCondition(){
        User user = new User();
        user.setUsername("%王%");
        user.setSex("女");
        List<User> users = userDao.findUserByCondition(user);
        for (User u: users) {
            System.out.println(u);
        }
    }

    /**
     * 测试foreach标签的使用
     */
    @Test
    public void testFindInIds(){
        QueryVo vo = new QueryVo();
        List<Integer> list = new ArrayList<Integer>();
        list.add(41);
        list.add(42);
        list.add(45);
        list.add(46);
        list.add(47);
        vo.setIds(list);
        List<User> users = userDao.findUserInIds(vo);
        for (User u: users) {
            System.out.println(u);
        }
    }
}
