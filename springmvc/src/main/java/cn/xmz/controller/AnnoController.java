package cn.xmz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("anno")
public class AnnoController {

    /*RequestParam的required属性默认开启*/
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name",required = true) String username){
        System.out.println("anno/testRequestParam");
        return "success";
    }

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println("anno/testRequestBody");
        System.out.println(body);
        return "success";
    }

    @RequestMapping("/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name = "sid") String id){
        System.out.println("anno/testPathVariable/10");
        System.out.println(id);
        return "success";
    }

    /*获取请求头信息*/
    @RequestMapping("/RequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header){
        System.out.println("anno/RequestHeader");
        System.out.println(header);
        return "success";
    }

    /*获取cookie内容*/
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue){
        System.out.println("anno/testCookieValue");
        System.out.println(cookieValue);
        return "success";
    }
}
