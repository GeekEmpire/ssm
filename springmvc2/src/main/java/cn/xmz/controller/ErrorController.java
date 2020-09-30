package cn.xmz.controller;

import cn.xmz.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("error")
public class ErrorController {

    @RequestMapping("/testException")
    public String testException() throws SysException{
        System.out.println("testException执行了");
        /*快捷键ctrl+alt+t，对选中代码块进行操作，如try catch*/
        try {
            int a =10/0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("查询所有用户出现错误");
        }
        return "error";
    }
}
