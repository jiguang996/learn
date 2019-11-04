package com.jiguang.ssm.controller;


import com.github.pagehelper.PageInfo;
import com.jiguang.ssm.domain.Product;
import com.jiguang.ssm.service.IProductService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;  //注入productService

    //查询所有产品
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size",required = true,defaultValue = "4") Integer size){
        ModelAndView mv=  new ModelAndView();
        List<Product>  productList=productService.findAll(page,size);
        //PageInfo就是一个分页Bean
        PageInfo pageInfo= new PageInfo(productList);
        mv.addObject("productList",pageInfo);
        mv.setViewName("product-list1");
        return mv;
    }

    //添加产品
    @RequestMapping("/save.do")
    public  String  save(Product product){
        productService.save(product);
        return "redirect:findAll.do";
    }
}
