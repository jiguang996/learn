package com.jiguang.myshop.web.admin.web.controller;

import com.jiguang.myshop.commons.dto.BaseResult;
import com.jiguang.myshop.commons.dto.PageInfo;
import com.jiguang.myshop.domain.TbContent;
import com.jiguang.myshop.domain.TbUser;
import com.jiguang.myshop.web.admin.service.TbContentService;
import com.jiguang.myshop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author ji
 * @Date 2019/10/20 22:15
 * @Version 1.0
 */

@Controller
@RequestMapping(value = "content")
public class ContentController {

    @Autowired
    private TbContentService tbContentService;

        @ModelAttribute
        public TbContent getTbContent(Long id) {
            TbContent tbContent = null;
            //id不为空从数据中获取
            if (id != null) {
                tbContent = tbContentService.findById(id);
            } else {
                tbContent = new TbContent();
            }
            return tbContent;
        }

        /**
         * 跳转内容列表页面
         *
         * @return
         */
        @RequestMapping(value = "/list", method = RequestMethod.GET)
        public String list() {
            return "content_list";
        }

        /**
         * 跳转内容列表页面
         *
         * @return
         */
        @RequestMapping(value = "/form", method = RequestMethod.GET)
        public String form() {
            return "content_form";
        }

        /**
         * 查询所有用户
         *
         * @return
         */
        @RequestMapping(value = "/findAll")
        public ModelAndView findAll() {
            ModelAndView mv = new ModelAndView();
            List<TbContent> tbContentList = tbContentService.findAll();
            mv.addObject("tbContents", tbContentList);
            mv.setViewName("content_list");
            return mv;
        }

        @RequestMapping(value = "/save", method = RequestMethod.POST)
        public String save(TbContent tbContent, RedirectAttributes redirectAttribute, Model model) {
            BaseResult baseResult = tbContentService.save(tbContent);
            //保存成功
            if (baseResult.getStatus() == 200) {
                redirectAttribute.addFlashAttribute("baseResult", baseResult);
                return "redirect:content/list";
            }
            //保存失败
            else {
                model.addAttribute("baseResult", baseResult);
                return "content_form";
            }
        }

        /**
         * 删除用户信息
         *
         * @param ids
         * @return
         */
        @RequestMapping(value = "/delete", method = RequestMethod.POST)
        public BaseResult delete(String ids) {
            BaseResult baseResult = null;
            if (StringUtils.isNoneBlank(ids)) {
                String[] idArray = ids.split(",");
                tbContentService.deleteMulti(idArray);
                baseResult.setMessage("删除内容成功");
            } else {
                baseResult = BaseResult.fail("删除内容失败");
            }
            return baseResult;

        }

        /**
         * 封装页面
         *
         * @param tbContent
         * @param request
         * @return
         */
        @ResponseBody
        @RequestMapping(value = "/page", method = RequestMethod.GET)
        public PageInfo<TbContent> page(TbContent tbContent, HttpServletRequest request) {
            String drawStr = request.getParameter("draw");
            String startStr = request.getParameter("start");
            String lengthStr = request.getParameter("length");
            int draw = drawStr == null ? 0 : Integer.parseInt(drawStr);
            int start = startStr == null ? 0 : Integer.parseInt(startStr);
            int length = lengthStr == null ? 10 : Integer.parseInt(lengthStr);
            //封装需要的结果
            PageInfo<TbContent> pageInfo = tbContentService.page(start, draw, length, tbContent);
            return pageInfo;
        }

        @RequestMapping(value = "/detail",method = RequestMethod.GET)
        public  String detail(TbContent tbContent){
            return "content_detail";
        }
    }


