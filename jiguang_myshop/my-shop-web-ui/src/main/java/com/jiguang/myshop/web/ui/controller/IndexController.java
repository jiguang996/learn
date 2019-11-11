package com.jiguang.myshop.web.ui.controller;

import com.jiguang.myshop.commons.utils.HttpClientUtils;
import com.jiguang.myshop.commons.utils.MapperUtils;
import com.jiguang.myshop.web.ui.api.API;
import com.jiguang.myshop.web.ui.api.ContentsAPI;
import com.jiguang.myshop.web.ui.dto.TbContent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Author ji
 * @Date 2019/10/25 15:53
 * @Version 1.0
 */
@Controller
public class IndexController {

    @RequestMapping(value ={"","index"},method = RequestMethod.GET)
    public  String index(Model model){
        requestContentsPPT(model);
        return "index";
    }

    private void requestContentsPPT(Model model) {
        List<TbContent> tbContents = ContentsAPI.ppt();
        System.out.println(tbContents);
        model.addAttribute("ppt", tbContents);
    }
}
