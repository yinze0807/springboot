package cn.bdqn.controller;


import cn.bdqn.entity.Shopping;
import cn.bdqn.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ShopCarController {
    @Autowired
    ShopCarService shopCarService;

    @GetMapping("/shopCart")
    public String shopCart(Model model){
       List<Shopping> list= shopCarService.selectAll();
       model.addAttribute("shop",list);
        return "shopCart";
    }
    @GetMapping("/delete/{cid}")
    public String delectCid(@PathVariable Integer cid){
        shopCarService.deleteCid(cid);
        return "redirect:/shopCart";
    }

}
