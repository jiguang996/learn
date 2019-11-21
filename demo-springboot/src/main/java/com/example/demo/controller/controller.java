package com.example.demo.controller;

import com.example.demo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author ji
 * @Date 2019/11/7 0:31
 * @Version 1.0
 */
@CrossOrigin(value = "*")
@RestController
public class controller {

    @GetMapping("/user")
    public User user(){
        User user=new User();
        user.setUsername("jijibooooooooom");
        return  user;
    }
    @GetMapping("/index")
    public  String sayHi(Model model){
        model.addAttribute("jiji", "name");
        return  "index" ;
    }
}
