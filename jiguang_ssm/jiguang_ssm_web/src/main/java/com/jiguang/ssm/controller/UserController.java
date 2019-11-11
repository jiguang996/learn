package com.jiguang.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.jiguang.ssm.domain.Orders;
import com.jiguang.ssm.domain.Role;
import com.jiguang.ssm.domain.UserInfo;
import com.jiguang.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private IUserService userService;



    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size",required = true,defaultValue = "4") Integer size){
        ModelAndView mv=  new ModelAndView();

        List<UserInfo> userInfoList=userService.findAll(page,size);
        PageInfo pageInfo= new PageInfo(userInfoList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("user-list");
        return  mv;
    }

    @RequestMapping("/save.do")
    public  String save(UserInfo userInfo) throws Exception {
        userService.save(userInfo);
        return  "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView findById(String id){
        ModelAndView mv=  new ModelAndView();
        UserInfo userInfo=userService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show1");
        return  mv;
    }

    @RequestMapping("/findUserByIdAndAllRole.do")
    public  ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) String userId){
        ModelAndView mv=  new ModelAndView();
        UserInfo userInfo = userService.findById(userId);
        List<Role> otherRoles = userService.findOtherRoles(userId);
        mv.addObject("user",userInfo);
        mv.addObject("roleList",otherRoles);
        mv.setViewName("user-role-add");
        return  mv;
    }

    @RequestMapping("/addRoleToUser.do")
    public  String addRoleToUser(@RequestParam(name = "userId",required = true) String userId,@RequestParam(name = "ids",required = true) String[] ids ) throws Exception {
        userService.addRoleToUser(userId,ids);

        return  "redirect:findAll.do";
    }
}
