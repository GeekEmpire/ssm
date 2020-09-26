package com.xmz.service.impl;

import com.xmz.service.IAccountService;

import java.util.Date;

public class AccountServiceImpl1 implements IAccountService {

    //经常变动的数据不适合注入的方式
    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了"+this.name+this.age+this.birthday);
    }

}
