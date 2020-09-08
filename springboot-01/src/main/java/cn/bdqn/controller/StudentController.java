package cn.bdqn.controller;

import cn.bdqn.config.StudentProperties;
import cn.bdqn.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController

public class StudentController {
    @Autowired
    IndexService indexService;
    @GetMapping("/index")
    public String index(){
        return indexService.getName();
    }
    @GetMapping("/student")
    public StudentProperties Student(){
        return indexService.Student();
    }


}
