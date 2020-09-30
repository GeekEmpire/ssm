package cn.xmz.controller;

import cn.xmz.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("testString")
    public String testString(Model model){
        System.out.println("testString");
        User user  = new User();
        user.setId(1);
        user.setUsername("美美");
        user.setPassword("123456");
        model.addAttribute("user", user);
        return "success";
    }

    /*无返回值默认请求/WEB-INF/pages/user/testVoid.jsp
    * 可以使用HttpServletRequest进行请求转发
    * */
//    @RequestMapping("testVoid")
//    public void testVoid(Model model){
//        System.out.println("testVoid");
//    }
    @RequestMapping("testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("testVoid");
        /*转发*/
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);

        /*重定向*/
//        response.sendRedirect(request.getContextPath()+"/WEB-INF/pages/success.jsp");

        /*设置中文乱码*/
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        /*直接响应*/
        response.getWriter().print("hello 世界");
    }

    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView(){
        System.out.println("testModelAndView");
        ModelAndView mv = new ModelAndView();
        User user  = new User();
        user.setId(1);
        user.setUsername("小明");
        user.setPassword("123456");
        /*会把user存入到request*/
        mv.addObject("user",user);
        /*跳转页面*/
        mv.setViewName("success");
        return mv;
    }

    @RequestMapping("testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect");
        /*转发*/
//        return "forward:/WEB-INF/pages/success.jsp";
        return "redirect:/index.jsp";
    }

//    @RequestMapping("testAjax")
//    public void testAjax(@RequestBody String body,HttpServletRequest request, HttpServletResponse response) throws Exception{
//        System.out.println("testAjax");
//        System.out.println(body);
//        /*设置中文乱码*/
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
//
//        /*直接响应*/
//        response.getWriter().print(body);
//    }
    @RequestMapping("testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax");
        System.out.println(user);
        user.setId(10);
        return user;
    }
}
