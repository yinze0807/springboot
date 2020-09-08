package cn.bdqn.service;

import cn.bdqn.config.StudentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
//@EnableConfigurationProperties(StudentProperties.class)
public class IndexService {
    @Value("${student.name}")
    String name;

    @Autowired
    StudentProperties studentProperties;


    public String getName(){
        return name;
    }
    public StudentProperties Student(){return studentProperties;}
}
