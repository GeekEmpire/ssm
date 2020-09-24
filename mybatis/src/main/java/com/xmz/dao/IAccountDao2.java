package com.xmz.dao;

import com.xmz.domain.Account;
import com.xmz.domain.AccountUser;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IAccountDao2 {

    @Select("select * from account")
    @Results(id = "accountMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(id = true, column = "uid", property = "uid"),
            @Result(id = true, column = "money", property = "money"),
            @Result(property = "user", column = "uid", one = @One(
                    select="com.xmz.dao.IUserDao.findById", fetchType= FetchType.EAGER))
    })
    List<Account> findAll();

    @Select("select * from account where uid = #{id}")
    List<Account> findAccountByUid(Integer uid);

    List<AccountUser> findAllAccount();
}
