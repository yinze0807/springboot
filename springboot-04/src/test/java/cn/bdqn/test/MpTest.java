package cn.bdqn.test;

import cn.bdqn.entity.User;
import cn.bdqn.mapper.UserMapper;
import cn.bdqn.service.CommodityService;
import cn.bdqn.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MpTest {
    @Autowired
    UserService userService;
    @Autowired
    CommodityService commodityService;
    @Test
    public void test01(){
        List<User> users = userService.findList();
        users.forEach(System.out::println);
    }
    @Test
    public void test03(){
        userService.insert();
    }
    @Test
    public void test04(){
        userService.finByWrapper2();
    }
    @Test
    public void test05(){
        userService.finByWrapper3();
    }
    @Test
    public void test06(){
        commodityService.selectGroup();
    }
    @Test
    public void test07(){
        commodityService.selectLambda();
    }
    @Test
    public void test08(){
        commodityService.selectUpdate();
    }
    @Test
    public void test09(){
        commodityService.delete();
    }
}
