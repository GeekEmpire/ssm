package cn.xmz.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {

    /*
    * 预处理，controller方法执行之前
    * return true 放行，执行下一个拦截器，如果没有执行controller中的方法
    * return false 不放行
    * */
//    ctrl + o快捷键实现接口方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor执行了");
//        request.getRequestDispatcher("/response.jsp").forward(request,response);
        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        return false;
//        return true;
    }



    //最后处理方法，最后以该方法的跳转为主
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
