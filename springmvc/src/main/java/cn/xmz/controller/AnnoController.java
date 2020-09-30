package cn.xmz.controller;

import cn.xmz.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.jws.soap.SOAPBinding;
import java.util.Map;

@Controller
@RequestMapping("anno")
@SessionAttributes(value = {"msg"})//吧msg=美美存到session域中
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

    /**/
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user){
        System.out.println("anno/testModelAttribute");
        System.out.println(user);
        return "success";
    }

    /*该方法会先执行,方式一*/
//    @ModelAttribute
////    public User showUser(){
////        User user = new User();
////        user.setId("1");
////        user.setName("1");
////        user.setPassword("1");
////        System.out.println("showUser");
////        return user;
////    }
    /*该方法会先执行,方式二*/
    @ModelAttribute
    public User showUser(Map<String, User>map){
        User user = new User();
        user.setId("1");
        user.setName("1");
        user.setPassword("1");
        map.put("abc",user);
        System.out.println("showUser");
        return user;
    }

    /*
    model设置
    ModelMap 取
    SessionStatus.setComplete清除session
    * */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model, ModelMap modelMap, SessionStatus status){
        System.out.println("anno/testSessionAttributes");
        /*底层会存储到request域对象中*/
        model.addAttribute("msg","美美");
        String msg = (String)modelMap.get("msg");
        System.out.println(msg);
        status.setComplete();
        return "success";
    }
}
