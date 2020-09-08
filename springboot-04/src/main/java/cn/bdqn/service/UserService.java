package cn.bdqn.service;

import cn.bdqn.entity.User;
import cn.bdqn.mapper.CommodityMapper;
import cn.bdqn.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public List<User> findList(){
        return userMapper.selectList(null);
    }

    public void insert(){
        User user = new User();
        user.setUsername("yyz");
        user.setPassword("123");
        user.setMoney(100);
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }
    public void finByWrapper2(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("money",20)
                    .or(wq->wq.gt("money",50).like("username","yyz"));

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }
    public void finByWrapper3(){
        Map<String,Object> map = new HashMap<>();
        map.put("money",10);
        map.put("username","yinzhe");
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt(map.containsKey("money"),"money",map.get("money"));
        queryWrapper.like(map.containsKey("username"),"username",map.get("yyz"));

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }



}
