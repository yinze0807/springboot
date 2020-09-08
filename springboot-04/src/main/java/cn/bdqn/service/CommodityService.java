package cn.bdqn.service;

import cn.bdqn.entity.Commodity;
import cn.bdqn.mapper.CommodityMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommodityService {
    @Autowired
    CommodityMapper commodityMapper;

    //分组查询
    public void selectGroup(){
        QueryWrapper<Commodity> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("nid","count(0)","avg(money)","sum(number)");
        //分组
        queryWrapper.groupBy("type");
        //条件
        queryWrapper.having("avg(money)>{0}",10);
        List<Map<String, Object>> maps = commodityMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }
    //模糊查询
    public void selectLambda(){
        LambdaQueryWrapper<Commodity> user = new LambdaQueryWrapper<>();
        user.like(Commodity::getName,"%冰%");
        List<Commodity> commodities1 = commodityMapper.selectList(user);

        //分页，需配置类
        Page<Commodity> commodityPage = commodityMapper.selectPage(new Page<Commodity>(1, 3), user);
        List<Commodity> commodities = commodityPage.getRecords();
        commodities.forEach(System.out::println);
        System.out.println("总条数："+commodityPage.getTotal());
        System.out.println("总页数："+commodityPage.getPages());
    }
    public void selectUpdate(){
        Commodity commodity = new Commodity();
        commodity.setName("冰红茶");
        commodity.setCid(8);
        commodity.setVersion(2);
        int i = commodityMapper.updateById(commodity);
        System.out.println(i);
    }
    public void delete(){
        int i = commodityMapper.deleteById(10);
        System.out.println(i);
    }
}
