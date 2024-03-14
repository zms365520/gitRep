package com.aks.controller;

import com.aks.pojo.User;
import com.aks.service.UserService;
import com.sun.jndi.cosnaming.CNNameParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @Auther: zms
 * @Date: 2024/2/26 - 02 - 26 - 9:28
 * @Description: com.aks.controller
 * @version: 1.0
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping("login.do")
    public String login(String cname,String room){
        String view="";
        User user=userService.findUser(cname,room);
        if(null!=user){
            view="/succ.jsp";
        }else{
            view="/fail.jsp";
        }
        return view;
    }

    @RequestMapping("/findAll.do")
    @ResponseBody
    public List<User> getAllUser(){
        List<User> list=userService.findAllUser();
        System.out.println();
        return list;
    }


    @RequestMapping("/test1.do")
    @ResponseBody
    public String getAllUser2(Model model){
        List<User> list=userService.findAllUser();
        model.addAttribute("list",list);
        //model不需要返回
        return "redirect:/xx.jsp";
    }

    @RequestMapping("/test2.do")
    public String getAllUser2(String cname){
        System.out.println(cname);
        //model不需要返回
        return "redirect:/xx.jsp";
    }

    //返回值是String类型的
    @RequestMapping("/login5.action")
    public String login2(String cname,String room,Map<String,Object> model){
        model.put("msg","zanghua,你好");
        System.out.println("login.action");
        User user = userService.findUser(cname, room);
        if(null!=user){
            return "succ.jsp";
        }else{
            return "fail.jsp";
        }
    }

    //返回值是ModelAndView类型的
    @RequestMapping("/login6.action")//这个请求配置了拦截器，会修改msg的信息，也会修改最后的跳转页面
    public ModelAndView login3(String cname,String room){
        ModelAndView mv=new ModelAndView();
        Map<String,Object> model=mv.getModel();
        model.put("msg","zanghua,你好");
        System.out.println("login.action");
        User user = userService.findUser(cname, room);
        if(null!=user){
            mv.setViewName("succ.jsp");
        }else{
            mv.setViewName("fail.jsp");
        }
        return mv;
    }
}
