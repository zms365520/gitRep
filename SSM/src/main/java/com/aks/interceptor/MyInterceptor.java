package com.aks.interceptor;

import com.aks.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Auther: zms
 * @Date: 2024/2/27 - 02 - 27 - 11:40
 * @Description: com.aks.interceptor
 * @version: 1.0
 */
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //请求到达自己定义的handler（controller）之前工作的
        System.out.println("MyInterceptor preHandle");
        //请求和响应的乱码处理
        //request.setCharacterEncoding("UTF-8");
        //response.setCharacterEncoding("UTF-8");

        //判断是否登录
        /*User user = (User) request.getSession().getAttribute("user");
        if (null == user)
            response.sendRedirect("index.jsp");
            return false;*/

        //return false;
        //用户权限控制
        //返回true，代表放行，可以继续到达handler*
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //handler处理单元返回modelandview时候进行拦截

        //可以对响应的结果进行处理 ModelAndView modelAndView
        /*modelAndView.setViewName("");
        modelAndView.getModelMap();*/

        Map<String, Object> map = modelAndView.getModel();
        String msg = (String)map.get("msg");
        String newMsg = msg.replaceAll("zanghua", "**");
        map.put("msg",newMsg);//控制数据
        modelAndView.setViewName("/haha.jsp");//可以修改跳转的页面,控制视图


        System.out.println("MyInterceptor postHandle");
    }

    //无论controller是否出现异常，都会执行的方法
    //一般来说是做一些资源释放的工作
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //页面渲染完毕，但是还没有给浏览器响应的时候执行

        System.out.println("MyInterceptor afterCompletion");
        //ex
    }
}
