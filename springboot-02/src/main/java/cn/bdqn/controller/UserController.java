package cn.bdqn.controller;

import cn.bdqn.entity.User;
import cn.bdqn.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;


import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String Register(){
        return "register";
    }@GetMapping("/login")
    public String Login(){
        return "login";
    }
    //登陆
    @PostMapping("/login/{username}/{password}")
    public String login(@Param("username")String username, @Param("password")Integer password, RedirectAttributesModelMap modelMap){
        Map<String,User> user = userService.selectUser(username,password);
        if(user!=null){
            modelMap.addFlashAttribute("user",user);
            return "redirect:/commodity";
        }else {
            return "login";
        }
    }
    //注册
    @PostMapping("/register/{username}/{password}")
    public String register(@Param("username")String username, @Param("password")Integer password){
        if(username!=null && password!=null){
            User user = new User(null,username,password,0);
            int commodity = userService.register(user);
            if(commodity==1){
                return "login";
            }else{
                return "register";
            }
        }else {
            return "register";
        }

    }

}
