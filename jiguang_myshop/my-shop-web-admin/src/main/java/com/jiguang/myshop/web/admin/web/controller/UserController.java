package com.jiguang.myshop.web.admin.web.controller;

import com.jiguang.myshop.commons.dto.BaseResult;
import com.jiguang.myshop.commons.dto.PageInfo;
import com.jiguang.myshop.domain.TbUser;
import com.jiguang.myshop.web.admin.abstracts.AbstractController;
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
 * 用户管理
 * @Author ji
 * @Date 2019/10/18 20:33
 * @Version 1.0
 */

@Controller
@RequestMapping("/user")
public class UserController  extends AbstractController<TbUser,TbUserService> {

    @ModelAttribute
    public TbUser  getTbUser(Long id) {
        TbUser tbUser = null;
        //id不为空从数据中获取
        if (id != null) {
            tbUser = service.findById(id)   ;
        } else {
            tbUser = new TbUser();
        }
        return tbUser;
    }

    /**
     * 跳转用户列表页面
     *
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "user_list";
    }

    /**
     * 跳转用户列表页面
     *
     * @return
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return "user_form";
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @RequestMapping(value = "/findAll")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView();
        List<TbUser> tbUserList = service.findAll();
        mv.addObject("tbUsers", tbUserList);
        mv.setViewName("user_list");
        return mv;
    }

    @RequestMapping(value = "save")
    public String save(TbUser tbUser, RedirectAttributes redirectAttribute, Model model) {
        BaseResult baseResult = service.save(tbUser);
        //保存成功
        if (baseResult.getStatus() == 200) {
            redirectAttribute.addFlashAttribute("baseResult", baseResult);
            return "redirect:list";
        }
        //保存失败
        else {
            model.addAttribute("baseResult", baseResult);
            return "user_form";
        }
    }

    /**
     * 删除用户信息
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(String ids) {
        BaseResult baseResult = null;
        if (StringUtils.isNoneBlank(ids)) {
            String[] idArray = ids.split(",");
            service.deleteMulti(idArray);
            baseResult.setMessage("删除用户成功");
        } else {
            baseResult = BaseResult.fail("删除用户失败");
        }
        return baseResult;

    }

    /**
     * 封装页面
     *
     * @param tbUser
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<TbUser> page(TbUser tbUser, HttpServletRequest request) {
        String drawStr = request.getParameter("draw");
        String startStr = request.getParameter("start");
        String lengthStr = request.getParameter("length");
        int draw = drawStr == null ? 0 : Integer.parseInt(drawStr);
        int start = startStr == null ? 0 : Integer.parseInt(startStr);
        int length = lengthStr == null ? 10 : Integer.parseInt(lengthStr);
        //封装需要的结果
        PageInfo<TbUser> pageInfo = service.page(start, draw, length, tbUser);
        return pageInfo;
    }

    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public  String detail(TbUser tbUser){
       return "user_detail";
    }
}
