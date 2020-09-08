package cn.bdqn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="user")
public class User {
    @Id
    private Integer uid;
    private String username;
    //连表查询，多对一，关联cid
    @JoinColumn(name = "cid")
    @JsonIgnore//序列化时忽略此属性
    @ManyToOne(fetch = FetchType.LAZY)//延迟加载：查询时不会填充类型，需要时才会填充
    private String password;
    //连表查询，多对多
    @ManyToMany
    @JoinTable(name = "中间表名",
                joinColumns = @JoinColumn(name = "当前表id",referencedColumnName = "当前表id"),
                    inverseJoinColumns = @JoinColumn(name = "关联表id",referencedColumnName = "关联表id"))
    private Integer moeny;
}
