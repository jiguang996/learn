package com.jiguang.myshopplus.business.feign.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 头像信息
 * @Author: GZG
 * @Create: 2019-11-27 18:35
 * @Version 1.0
 **/
@Data
public class IconParam  implements Serializable {
    private  String username;
    private  String path;
}
