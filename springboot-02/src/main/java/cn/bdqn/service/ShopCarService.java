package cn.bdqn.service;

import cn.bdqn.entity.Shopping;
import cn.bdqn.mapper.ShoppingcartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopCarService {
    @Autowired
    ShoppingcartMapper shoppingcartMapper;

    public List<Shopping> selectAll(){
        return shoppingcartMapper.selectByExample(null);
    }

    public Shopping selectNumber(Integer number){
        return shoppingcartMapper.selectNumber(number);
    }

    public int updetaNumber(Integer cid){
        return shoppingcartMapper.uptateNumber(cid);
    }
    public int insert(Shopping shopping){
        return shoppingcartMapper.insert(shopping);
    }
    public int deleteCid(Integer cid){
        return shoppingcartMapper.deleteByPrimaryKey(cid);
    }

}
