package com.xmz.dao;

import com.xmz.domain.QueryVo;
import com.xmz.domain.User;

import javax.management.Query;
import java.util.List;

public interface IUserDao {
    /**
     * 查询所以用户
     */
//    @Select("select * from user")
    List<User> findAll();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Integer id);

    User findById(Integer id);

    List<User> findByName(String username);

    int findTotal();

    /**
     * 根据QueryVo中的条件进行查询
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据QueryVo中的条id集合，进行查询
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);

    /**
     * 根据传入参数条件进行查询
     * @param user
     * @return
     */
    List<User> findUserByCondition(User user);
}
