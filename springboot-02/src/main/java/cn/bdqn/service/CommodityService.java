package cn.bdqn.service;
import cn.bdqn.Dao.CommodityDao;
import cn.bdqn.entity.Commodity;
import cn.bdqn.mapper.CommodityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class CommodityService {
    @Autowired
    CommodityMapper commodityMapper;
    @Autowired
    CommodityDao commodityDao;

    public List<Commodity> selectAll(Integer page, Model model){
        //创建分页
        Pageable pageable = PageRequest.of(page-1,2);
        System.out.println("-----------当前页为："+page+"-----------");
        //page注意包是org.springframework.data.domain.Page
        Page<Commodity> all = commodityDao.findAll(pageable);
        //取出查询的集合
        List<Commodity>list = all.getContent();
        model.addAttribute("count",all.getTotalPages());
//        //取出查询的总页数
//        System.out.println(all.getTotalPages());
//        //取出查询的总条数
//        System.out.println(all.getTotalElements());
        return list;
    }
    public Commodity selectNumber(Integer number){
        return commodityMapper.selectNumber(number);
    }


}
