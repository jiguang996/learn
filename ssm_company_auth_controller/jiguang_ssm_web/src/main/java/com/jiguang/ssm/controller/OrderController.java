package com.jiguang.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiguang.ssm.domain.Orders;
import com.jiguang.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private IOrdersService ordersService;

    @RequestMapping("/findAll.do")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size",required = true,defaultValue = "4") Integer size){
        ModelAndView mv=  new ModelAndView();
        List<Orders> ordersList=ordersService.findAll(page,size);
        PageInfo pageInfo= new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return  mv;
    }

    @RequestMapping("/findById.do")
    public  ModelAndView findById(@RequestParam(name = "id",required = true) String orderId){
        ModelAndView mv=  new ModelAndView();
        Orders orders =ordersService.findById(orderId);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return  mv;
    }
}
