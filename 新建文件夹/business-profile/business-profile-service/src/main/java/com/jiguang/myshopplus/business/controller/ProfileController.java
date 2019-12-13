package com.jiguang.myshopplus.business.controller;

import com.jiguang.myshopplus.business.feign.dto.IconParam;
import com.jiguang.myshopplus.business.feign.dto.PasswordParam;
import com.jiguang.myshopplus.business.feign.dto.ProfileParam;
import com.jiguang.myshopplus.commons.dto.ResponseResult;
import com.jiguang.myshopplus.provider.api.UmsAdminService;
import com.jiguang.myshopplus.provider.api.domain.UmsAdmin;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: 个人信息管理
 * @Author: GZG
 * @Create: 2019-11-26 17:06
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "profile")
public class ProfileController {

    @Reference(version = "1.0.0")
    private UmsAdminService umsAdminService;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * 获取个人信息
     *
     * @param username 用户名
     * @return {@link ResponseResult}
     */
    @GetMapping(value = "info/{username}")
    public ResponseResult<UmsAdmin> info(@PathVariable String username) {
        UmsAdmin umsAdmin = umsAdminService.get(username);
        return new ResponseResult<UmsAdmin>(ResponseResult.CodeStatus.OK, "获取个人信息", umsAdmin);
    }

    /**
     * 更新个人信息
     * @param profileParam
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<Void>  update(@RequestBody ProfileParam profileParam){
        UmsAdmin umsAdmin=new UmsAdmin();
        BeanUtils.copyProperties(profileParam,umsAdmin);
        int result = umsAdminService.update(umsAdmin);

        //更新成功
        if(result>0){
            return  new ResponseResult<Void>(ResponseResult.CodeStatus.OK,"更新个人信息成功");
        }

        //失败
        else {
            return  new ResponseResult<Void>(ResponseResult.CodeStatus.FAIL,"更新失败");
        }
    }

    /**
     * 修改密码
     * @param passwordParam
     * @return
     */
    @PostMapping(value = "modify/password")
    public  ResponseResult<Void> modifyPassword(@RequestBody PasswordParam passwordParam){
        UmsAdmin umsAdmin = umsAdminService.get(passwordParam.getUsername());

        //修改成功
        if(passwordEncoder.matches(passwordParam.getOldPassword(), umsAdmin.getPassword())){
            if(! passwordParam.getNewPassword().equals(passwordParam.getOldPassword())){
                int result = umsAdminService.modifyPassword(umsAdmin.getUsername(), passwordParam.getNewPassword());
                if(result>0) {
                    return new ResponseResult<Void>(ResponseResult.CodeStatus.OK, "修改密码成功");
                }
            }

            else {
                return  new ResponseResult<Void>(ResponseResult.CodeStatus.FAIL,"修改前后密码相同");
            }
        }
        //失败
        else {
            return new ResponseResult<Void>(ResponseResult.CodeStatus.FAIL, "旧密码不匹配，请重试");
        }
        return  new ResponseResult<Void>(ResponseResult.CodeStatus.FAIL,"修改密码失败！！！");
    }

    /**
     * 修改头像
     * @param iconParam
     * @return
     */
    @PostMapping(value = "modify/icon")
    public  ResponseResult<Void> modifyIcon(@RequestBody IconParam iconParam){
        int result = umsAdminService.modifyIcon(iconParam.getUsername(), iconParam.getPath());

        //更新成功
        if(result>0){
            return  new ResponseResult<Void>(ResponseResult.CodeStatus.OK,"更新头像成功");
        }

        //失败
        else {
            return  new ResponseResult<Void>(ResponseResult.CodeStatus.FAIL,"更新头像失败");
        }
    }

}


