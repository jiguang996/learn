package com.jiguang.myshop.web.ui.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author ji
 * @Date 2019/10/26 0:38
 * @Version 1.0
 */
@Data
public class TbUser implements Serializable {

    private Long id;
    private String username   ;
    private String password;
    private String phone;
    private String email;
    private  String verification;

}
