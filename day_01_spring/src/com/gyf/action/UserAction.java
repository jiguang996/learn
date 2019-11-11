//package com.gyf.action;
//
//import com.gyf.model.User;
//import com.gyf.service.IUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//
//import javax.annotation.Resource;
//
//@Controller("userAction")
//public class UserAction {
//    @Resource(name = "userService")
//    IUserService  iUserService;
//
//    public void save(){
//        System.out.println("action保存");
//        User u = new User();
//        u.setName("123123");
//        //iUserService.save(u);
//    }
//}
