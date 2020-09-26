package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
* 该类是一个配置类，作用同bean.xml
* spring中的新注解
* Configuration:指定当前类是一个配置类
* ComponentScan：指定创建容器时要扫描的包
*       属性：
*           value：和basePackages的作用一样，用于指定要扫描的包
* Bean:把当前方法的返回值存入到spring的ioc容器中
*       属性：
*          name：用于指定bean的id，不写时默认为当前方法的名称
* 细节：当使用注解配置方法时，如果方法有参数，spring框架会在容器中找有没有可用的bean对象，同Autowired
*Import:用于导入其他配置类的字节码
*       属性：value
* PropertySource:指定properties源
*       属性：value=“classpath：。。。。”
* */
@Configuration
@ComponentScan(basePackages = "com.xmz")
public class SpringConfiguration {

}
