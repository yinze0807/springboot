package cn.bdqn.mapper;

import cn.bdqn.entity.Shopping;
import cn.bdqn.entity.ShoppingExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ShoppingcartMapper {
    long countByExample(ShoppingExample example);

    int deleteByExample(ShoppingExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(Shopping record);

    int insertSelective(Shopping record);

    List<Shopping> selectByExample(ShoppingExample example);

    Shopping selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") Shopping record, @Param("example") ShoppingExample example);

    int updateByExample(@Param("record") Shopping record, @Param("example") ShoppingExample example);

    int updateByPrimaryKeySelective(Shopping record);

    int updateByPrimaryKey(Shopping record);
    @Update("update shoppingcart set trade_number=trade_number+1,count=count+trade_moeny where number=#{number}")
    int uptateNumber(Integer number);
    @Select("select * from shoppingcart where number=#{number}")
    Shopping selectNumber(Integer number);
}