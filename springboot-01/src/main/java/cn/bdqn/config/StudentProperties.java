package cn.bdqn.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

//所有的GET SET方法
@Data
//@ConfigurationProperties (prefix = "student")
//@AllArgsConstructor   所有的有参构造方法
public class StudentProperties {
    private String name;
    private Integer age;
    private double phone;
}
