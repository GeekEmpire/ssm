package cn.xmz.controller;

import cn.xmz.domain.Account;
import cn.xmz.domain.Many;
import cn.xmz.domain.UserDate;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/param")
public class ParamController {

    @RequestMapping("/test")
    public String testParam(String username){
        System.out.println("执行了paramTest"+username);
        return "success";
    }

    @RequestMapping("bean")
    public String testBean(Account account){
        System.out.println(account);
        return "success";
    }

    @RequestMapping("save")
    public String testSave(Many many){
        System.out.println(many);
        return "success";
    }

    @RequestMapping("date")
    public String testDatee(UserDate date){
        System.out.println(date);
        return "success";
    }

    @RequestMapping("servlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request);
        HttpSession session = request.getSession();
        System.out.println(session);
        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);
        System.out.println(response);
        return "success";
    }
}
