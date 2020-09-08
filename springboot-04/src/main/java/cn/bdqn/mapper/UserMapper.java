package cn.bdqn.mapper;

import cn.bdqn.entity.User;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.yaml.snakeyaml.scanner.Constant;

import java.util.List;
import java.util.function.Consumer;

public interface UserMapper extends BaseMapper<User>{
    @Select("select * from user ${ew.customSqlSegment}")
     List<User> selectAll(@Param(Constants.WRAPPER) Wrapper<User> wrappers);
}
