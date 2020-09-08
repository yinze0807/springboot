package cn.bdqn.service;

import cn.bdqn.entity.User;
import cn.bdqn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public List<User> selectAll(){

       List<User> list = userMapper.selectByExample(null);
       return list;
    }
    public Map<String,User> selectUser(String username,Integer password){
       return userMapper.selectUser(username,password);
    }
    public int register(User user){
        return userMapper.insert(user);
    }
}
