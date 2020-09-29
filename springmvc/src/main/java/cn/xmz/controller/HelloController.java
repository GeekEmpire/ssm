package cn.xmz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/he")
public class HelloController {

    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("hello world");
        return "success";
    }

    /**
     *  属性：
     *      path和value一样
     *      method设置请求方式
     *      params指定限制请求参数的条件，支持简单的表达式，请求参数的key和value必须和配置的一模一样
     *      headers：限制请求头的条件
     * @return
     */
    @RequestMapping(path = "/testRequestMapping",method = {RequestMethod.POST},
            params = {"username","password=123"},headers = {"Accept"})
    public String testRequestMapping(){
        System.out.println("测试RequestMapping");
        return "success";
    }
}
