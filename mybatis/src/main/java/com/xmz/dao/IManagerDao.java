package com.xmz.dao;

import com.xmz.domain.Manager;
import com.xmz.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IManagerDao {

    @Select("select * from manager ")
    @Results(id = "managerMap", value = {
            @Result(id=true, column = "id", property = "id"),//id指示主键
            @Result(column = "name", property = "name"),
            @Result(column = "password", property = "password"),
    })
    List<Manager> findAll();

    @Select("select * from manager where id = #{id} ")
    @ResultMap(value = {"managerMap"})   //@ResultMap("managerMap")
    List<Manager> findById(int id);

//    @Select("select * from user where username like '%${value}%' ")
    @Select("select * from manager where name like #{name} ")
    @ResultMap("managerMap")
    List<Manager> findByName(String username);

    @Insert("insert into manager (name, password) values (#{name}, #{password}) ")
    @ResultMap("managerMap")
    void saveManager(Manager manager);

    @Update("update manager set name = #{name}, password = #{password} where id = #{id}")
    @ResultMap("managerMap")
    void updateManager(Manager manager);

    @Delete("delete from manager where id = #{id} ")
    @ResultMap("managerMap")
    void delete(int id);

    @Select("select count(*) from manager")
    int findTotal();

}
