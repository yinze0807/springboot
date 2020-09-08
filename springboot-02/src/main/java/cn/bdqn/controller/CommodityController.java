package cn.bdqn.controller;

import cn.bdqn.entity.Commodity;
import cn.bdqn.entity.Shopping;
import cn.bdqn.service.CommodityService;
import cn.bdqn.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CommodityController {
    @Autowired
    CommodityService commodityService;
    @Autowired
    ShopCarService shopCarService;

    @GetMapping("/commodity")
    public String commodity(Model model){
        Integer page = 1;
        model.addAttribute("page",page);

        List<Commodity> list = commodityService.selectAll(page,model);
        model.addAttribute("com",list);

        return "commodity";
    }

    @GetMapping("/addCart/{number}")
    public String addCart(@PathVariable Integer number){
         Shopping shop = shopCarService.selectNumber(number);
         System.out.println("购物车查询数据结果:"+shop);
         if(shop!=null){
             int update=shopCarService.updetaNumber(number);
             System.out.println("修改数量结果："+update);
             return "redirect:/commodity";
         }else {
             Shopping shopping = new Shopping();
             Commodity commodity = commodityService.selectNumber(number);
             System.out.println("商品数据查询结果："+commodity);
             shopping.setNumber(commodity.getNumber());
             shopping.setTradeMoeny(commodity.getTradeMoeny());
             shopping.setTradeName(commodity.getTradeName());
             shopping.setTradeNumber(1);
             shopping.setCount(commodity.getTradeMoeny());
             int insert= shopCarService.insert(shopping);
             System.out.println("添加数据结果："+shopping.toString());
             return "redirect:/commodity";
         }

    }
    @GetMapping("/upper/{page}")
    public String upper(@PathVariable Integer page , Model model){
        if(page>0){
            List<Commodity> list = commodityService.selectAll(page,model);
            model.addAttribute("com",list);
            return "/commodity";
        }else{
            return "/commodity";
        }
    }
    @GetMapping("/lower/{page}")
    public String lower(@PathVariable Integer page,Model model){
        if(page!=1){
            List<Commodity> list = commodityService.selectAll(page,model);
            model.addAttribute("com",list);
            return "/commodity";
        }else {
            return "/commodity";
        }
    }


}
