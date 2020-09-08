package cn.bdqn.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
public class Commodity{
    @TableId
    private Integer cid;

    private Integer nid;

    private String name;

    private Integer money;

    private Integer number;

    private Integer type;
    //版本列
    @Version
    private Integer version;

    //逻辑删除列
    @TableLogic(value = "0",delval = "1")
    private Integer status;
}
