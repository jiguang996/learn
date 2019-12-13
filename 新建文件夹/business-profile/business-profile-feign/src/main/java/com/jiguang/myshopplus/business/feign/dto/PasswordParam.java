package com.jiguang.myshopplus.business.feign.dto;

import lombok.Data;

/**
 * @description: 修改密码
 * @Author: GZG
 * @Create: 2019-11-27 18:52
 * @Version 1.0
 **/
@Data
public class PasswordParam {
    private  String username;
    private String oldPassword;
    private String newPassword;
}
