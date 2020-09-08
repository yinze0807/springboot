package cn.bdqn.dao;

import cn.bdqn.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserDao extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {

}
