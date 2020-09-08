package cn.bdqn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    public StudentProperties student(){
        StudentProperties student = new StudentProperties();
        student.setName("张三");
        student.setAge(12);
        student.setPhone(123124124);
        return student;
    }
}
