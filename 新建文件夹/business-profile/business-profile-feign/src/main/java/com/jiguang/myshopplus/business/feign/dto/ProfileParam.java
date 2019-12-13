package com.jiguang.myshopplus.business.feign.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:个人信息参数
 * @Author: GZG
 * @Create: 2019-11-27 10:59
 * @Version 1.0
 **/
@Data
public class ProfileParam implements Serializable {


    private Long id;


    private String username;

    private String password;

    /**
     * 头像
     */
    private String icon;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 备注信息
     */
    private String note;

    /**
     * 创建时间
     */

    private Date createTime;

    /**
     * 最后登录时间
     */

    private Date loginTime;

    /**
     * 帐号启用状态：0->禁用；1->启用
     */

    private Integer status;
}
