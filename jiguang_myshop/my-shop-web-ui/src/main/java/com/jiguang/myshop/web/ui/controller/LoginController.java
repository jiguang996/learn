package com.jiguang.myshop.web.ui.controller;

import com.google.code.kaptcha.Constants;
import com.jiguang.myshop.commons.dto.BaseResult;
import com.jiguang.myshop.web.ui.api.UserAPI;
import com.jiguang.myshop.web.ui.dto.TbUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author ji
 * @Date 2019/10/26 0:48
 * @Version 1.0
 */
@Controller
public class LoginController {

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public  String login(){
        return  "login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public  String login(TbUser tbUser, Model model, HttpServletRequest request) throws Exception {
        if (! checkVerification(tbUser,request)){
            model.addAttribute("baseResult",BaseResult.fail("验证码输入错误"));
            return  "login";
        }

        TbUser login = UserAPI.login(tbUser);
        if (tbUser==null){
            model.addAttribute("baseResult",BaseResult.fail("用户名或密码错误，请重新输入"));
            return  "login";
        } else {
            //将会员信息存入session
            request.getSession().setAttribute("tbUser",tbUser);
            return "redirect:/index";
        }
    }


    public  boolean checkVerification(TbUser tbUser,HttpServletRequest request){
        String verificationUser=tbUser.getVerification();
        String verificationPic = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (StringUtils.equals(verificationUser,verificationPic)){
            return  true;
        }else {
            return  false;
        }
    }
}
