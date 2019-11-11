package com.jiguang.myshop.web.ui.api;

import com.jiguang.myshop.commons.dto.BaseResult;
import com.jiguang.myshop.commons.utils.HttpClientUtils;
import com.jiguang.myshop.commons.utils.MapperUtils;
import com.jiguang.myshop.web.ui.dto.TbContent;
import com.jiguang.myshop.web.ui.dto.TbUser;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * 会员管理接口
 * @Author ji
 * @Date 2019/10/26 0:38
 * @Version 1.0
 */
public class UserAPI  {
    /**
     * 登录请求
     * @param tbUser
     * @return
     */
    public  static TbUser login(TbUser tbUser) throws Exception {
        List<BasicNameValuePair>  params=new ArrayList<>();
        params.add(new BasicNameValuePair("username",tbUser.getUsername()));
        params.add(new BasicNameValuePair( "password",tbUser.getPassword()));
        String json = HttpClientUtils.doPost(API.API_USERS_LOGIN, params.toArray(new BasicNameValuePair[params.size()]));
        TbUser user = MapperUtils.json2pojoByTree(json, "data", TbUser.class);
        return user;
    }
}

