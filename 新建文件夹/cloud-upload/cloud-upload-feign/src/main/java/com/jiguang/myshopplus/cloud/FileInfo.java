package com.jiguang.myshopplus.cloud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description: 文件信息
 * @Author: GZG
 * @Create: 2019-11-27 17:01
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileInfo implements Serializable {
    /**
     * 文件路径
     */
    private String path;
}