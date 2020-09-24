package com.xmz.dao;

import com.xmz.domain.QueryVo;
import com.xmz.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IUserDao2 {
    /**
     * 查询所以用户
     */
    @Select("select * from user")
    @Results(id="userMap",value={
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "address",property = "address"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "birthday",property = "birthday"),
            @Result(property = "accounts",column = "id",
                    many = @Many(select = "com.xmz.dao.IAccountDao2.findAccountByUid",
                            fetchType = FetchType.LAZY))
    })
    List<User> findAll();
}
