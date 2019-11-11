package com.jiguang.myshop.web.ui.api;

import com.jiguang.myshop.commons.utils.HttpClientUtils;
import com.jiguang.myshop.commons.utils.MapperUtils;
import com.jiguang.myshop.web.ui.dto.TbContent;

import java.util.List;

/**
 * @Author ji
 * @Date 2019/10/25 17:39
 * @Version 1.0
 */
public class ContentsAPI  {
    public  static List<TbContent> ppt(){
        List<TbContent> tbContents = null;
        String result = HttpClientUtils.doGet(API.API_CONTENTS_PPT);
        try {
            tbContents = MapperUtils.json2listByTree(result, "data", TbContent.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tbContents;
    }
}

