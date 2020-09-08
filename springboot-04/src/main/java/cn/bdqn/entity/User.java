package cn.bdqn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User {
    @TableId//(type = IdType.AUTO)自增 //代表主键
    private Integer uid;
    @TableField //代表列名
    private String username;

    private String password;

    private Integer money;
}
