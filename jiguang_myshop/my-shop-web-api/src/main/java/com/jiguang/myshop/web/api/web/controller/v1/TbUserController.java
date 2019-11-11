package com.jiguang.myshop.web.api.web.controller.v1;

import com.jiguang.myshop.commons.dto.BaseResult;
import com.jiguang.myshop.domain.TbContent;
import com.jiguang.myshop.domain.TbUser;
import com.jiguang.myshop.web.api.service.TbUserService;
import com.jiguang.myshop.web.api.web.dto.TbUserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 会员管理
 * <p>Title: TbUserController</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/7/6 9:16
 */
@RestController
@RequestMapping(value = "${api.path.v1}/users")
public class TbUserController {

    @Autowired
    private TbUserService tbUserService;

    /**
     * 登录
     *
     * @param tbUser
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public BaseResult login(TbUser tbUser) {
        TbUser tbUser1 = tbUserService.login(tbUser);
        if (tbUser1 == null) {
            return BaseResult.fail("用户名或密码错误");
        } else {
            TbUserDTO tbUserDTO = new TbUserDTO();
            BeanUtils.copyProperties(tbUser1, tbUserDTO);
            return BaseResult.success("登录成功", tbUserDTO);
        }
    }
}