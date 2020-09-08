package cn.bdqn.Dao;

import cn.bdqn.entity.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommodityDao extends JpaRepository<Commodity,Integer> {
}
