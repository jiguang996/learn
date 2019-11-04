package com.jiguang.ssm.controller;


import com.github.pagehelper.PageInfo;
import com.jiguang.ssm.domain.Permission;
import com.jiguang.ssm.domain.Role;
import com.jiguang.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {


    @Autowired
    private IRoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size",required = true,defaultValue = "4") Integer size){
        ModelAndView mv= new ModelAndView();
        List<Role> roleList=roleService.findAll(page,size);
        PageInfo pageInfo=  new PageInfo(roleList);
        mv.addObject("roleList",pageInfo);
        mv.setViewName("role-list");
        return  mv;
    }

    @RequestMapping("/save.do")
    public  String save(Role role){
        roleService.save(role);
        return "redirect:findAll.do";
    }
    @RequestMapping("/findById.do")
    public ModelAndView  findById(String id){
        ModelAndView mv=  new ModelAndView();
        Role role=roleService.findById(id);
        mv.addObject("role",role);
        mv.setViewName("role-show");
        return  mv;
    }
    @RequestMapping("/deleteRole.do")
    public  String deleteRole(String id){
        roleService.deleteRole(id);
        return  "redirect:findAll.do";
    }
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "permissionids",required = true) String[] permissionIds,@RequestParam(name = "roleId",required = true) String roleId){
        roleService.addPermissionToRole(permissionIds,roleId);
        return  "redirect:findAll.do";
    }
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public  ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "roleId" ,required =  true ) String roleId){
        ModelAndView mv=  new ModelAndView();
        Role role=roleService.findById(roleId);
        List<Permission> permissionList=  roleService.findOtherPermissions(roleId);
        mv.addObject("role",role);
        mv.addObject("permissionList",permissionList);
        mv.setViewName("role-permission-add");
        return  mv;
    }
}
