package cn.bdqn.controller;

import cn.bdqn.entity.User;
import cn.bdqn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/index")
    public List<User> selectAll(){
        return userService.selectAll();
    }

    @GetMapping("/indexs")
    public Page<User> selectPage(){
        Map<String,Object>map = new HashMap<>();
        map.put("username","%in%");
        map.put("password","23");
        map.put("page",2);
        map.put("rows",3);
        Page<User> list = userService.selectPage(map);
        return list;
    }

}
