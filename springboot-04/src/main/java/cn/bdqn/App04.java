package cn.bdqn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//给所有@mapper
@MapperScan(basePackages = "cn.bdqn.mapper")
@SpringBootApplication
public class App04 {
    public static void main(String[] args) {
        SpringApplication.run(App04.class,args);
    }
}
