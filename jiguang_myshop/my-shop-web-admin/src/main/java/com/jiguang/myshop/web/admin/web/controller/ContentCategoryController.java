package com.jiguang.myshop.web.admin.web.controller;

import com.jiguang.myshop.domain.TbContent;
import com.jiguang.myshop.domain.TbContentCategory;
import com.jiguang.myshop.web.admin.service.TbContentCategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * 内容分类管理
 * @Author ji
 * @Date 2019/10/20 16:24
 * @Version 1.0
 */
@Controller
@RequestMapping(value = "/content/category")
public class ContentCategoryController {
    @Autowired
    private TbContentCategoryService TbContentCategoryService;


    @ModelAttribute
    public TbContentCategory getTbContentCategory(Long id) {
        TbContentCategory tbContentCategory = null;
        //id不为空从数据中获取
        if (id != null) {
            tbContentCategory = TbContentCategoryService.findById(id);
        } else {
            tbContentCategory = new TbContentCategory();
        }
        return tbContentCategory;
    }
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public  String findAll(Model model){
        List<TbContentCategory> targetList=new ArrayList<>();
        List<TbContentCategory> tbContentCategoryList =TbContentCategoryService.findAll();
        //排序
        sort(tbContentCategoryList, targetList, 0L);
        model.addAttribute("tbContentCategories",tbContentCategoryList);
        return  "content_category_list";
    }

    /**
     * 排序
     * @param sourceList 数据源集合
     * @param targetList 目标集合
     * @param parentId 父节点 id
     */
    private   void sort(List<TbContentCategory> sourceList, List<TbContentCategory> targetList,Long parentId){
        for(TbContentCategory tbContentCategory:sourceList){
            if (tbContentCategory.getId().equals(parentId)){
                targetList.add(tbContentCategory);
                if (tbContentCategory.isParent()){
                    for (TbContentCategory tbContentCategory1:sourceList){
                        if(tbContentCategory1.getParentId().equals(tbContentCategory.getId())){
                            sort(sourceList,targetList,tbContentCategory.getId());
                            break;
                        }
                    }

                }
            }

        }
    }
}
