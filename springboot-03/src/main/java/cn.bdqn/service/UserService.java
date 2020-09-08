package cn.bdqn.service;

import cn.bdqn.dao.UserDao;
import cn.bdqn.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    //普通分页
    public List<User> selectAll(){
        Pageable pageable = PageRequest.of(1,2);
        Page<User> page = userDao.findAll(pageable);
        List<User> list = page.getContent();
        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());
        return list;
    }
    //复杂分页
    public Page<User> selectPage(Map<String,Object> map){
        Integer page = (Integer) map.get("page");
        Integer rows = (Integer) map.get("rows");
        Pageable pageable = PageRequest.of(page-1,rows);
        Specification<User> user = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                //like包含，gt大于，lt小于，equal等于
                if(map.get("username")!=null){
                    Predicate p1 = criteriaBuilder.like(root.get("username"),map.get("username").toString());
                        list.add(p1);
                }
                if(map.get("password")!=null){
                    Predicate p2 = criteriaBuilder.like(root.get("password"),map.get("password").toString());
                    list.add(p2);
                }
                //转换集合为数组（new 数组类型【长度】）
                return criteriaBuilder.and(list.toArray(new Predicate[list.size()]));
            }
        };
        Page<User> all = userDao.findAll(user,pageable);
        List<User> list = all.getContent();
        System.out.println(all.getTotalPages());
        System.out.println(all.getTotalElements());
        return all;
    }

}
