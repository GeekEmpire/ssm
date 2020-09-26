package com.xmz.service.impl;

import com.xmz.dao.IAccountDao;
import com.xmz.factory.BeanFactory;
import com.xmz.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.annotation.Resources;

/**
 * 曾经的xml配置
 * <bean id="accountService" class="com.xmz.service.impl.AccountServiceImpl"
 *      scope=" init-method="", destroy-method="">
 *      <property name="" value=""/ref=""></property>
 * </bean>
 *
 * 用于创建对象的 bean  ===  @Component
 *     属性value：指定bean的id，不写默认是当前类名，且首字母改小写
 *     Controller：表现层
 *     Service：业务层
 *     Reposity：持久层
 *     以上三个作用和属性和Component作用一样，是spring框架为我们提供明确的三层使用的注解，使我们三层对象更加清晰
 * 用于注入数据的 property
 *      Autowired:
 *          作用：自动注入，只要有bean对象类型和要注入的变量类型匹配一对一，就可以注入成功
 *              若是没有，或者有多个则需要再通过变量名匹配，若匹配后还是一样则报错
 *          出现位置可以是变量成员，也可以是方法
 *      Qualifier:
 *          作用：在按照类注入的基础上再按名称注入，在给类成员注入时不能单独使用，但是给方法参数注入时可以使用
 *          属性：value指定注入bean的id
 *      Resource：
 *          作用：直接按照bean的id注入
 *          属性：name用于指定id
 *      以上三种只能注入其他bean类型的数据，而基本类型和string类型无法实现注入
 *      另外集合类型的注入之只能通过xml来实现
 *
 *      Value：
 *          作用：用于注入基本类型和string类型
 *          属性：
 *              value：用于指定数据的值，可以使用spring的SpEL(也就是spring的el表达式）Spel的写法：${表达式}
 *
 *
 *
 * 用于改变作用范围的  scope
 *      Scope
 *          作用：用于指定Bean的作用范围
 *          属性：value-》指定范围的取值，常用singLeton和prototype，默认前者即单例
 * 和生命周期有关的 init destroy
 *      PreDestroy:指定销毁方法
 *      PostConstruct：指定初始化方法
 */
@Component
@Scope("prototype")
public class AccountServiceImpl3 implements IAccountService {

//    @Autowired
//    @Qualifier("accountDao2")   //必须和Autowired配合
    @Resource(name = "accountDao2")
    private IAccountDao accountDao;
//    private IAccountDao accountDao1;
//    private IAccountDao accountDao2;

    public AccountServiceImpl3(){
        System.out.println("对象创建了");
    }

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
