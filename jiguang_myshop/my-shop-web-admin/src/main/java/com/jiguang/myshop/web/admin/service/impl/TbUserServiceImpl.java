package com.jiguang.myshop.web.admin.service.impl;
import com.jiguang.myshop.commons.dto.BaseResult;
import com.jiguang.myshop.commons.dto.PageInfo;
import com.jiguang.myshop.commons.utils.RegexpUtils;
import com.jiguang.myshop.commons.validator.BeanValidator;
import com.jiguang.myshop.domain.TbUser;
import com.jiguang.myshop.web.admin.dao.TbUserDao;
import com.jiguang.myshop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserDao userDao;

    @Override
    public TbUser login(String email, String password) {
        TbUser tbUser=userDao.findByEmail(email);
        if (tbUser!= null){
            //密码加密
            String md5Password=DigestUtils.md5DigestAsHex(password.getBytes());
            //判断加密后的密码和数据库中的是否一致，匹配则表示允许登录
            if (md5Password.equals(tbUser.getPassword())){
                return  tbUser;
            }
        }
        return null;
    }

    @Override
    public List<TbUser> findAll() {
        return userDao.findAll();
    }

    @Override
    public BaseResult save(TbUser tbUser) {
        String validator = BeanValidator.validator(tbUser);
        //验证不通过
        if (validator != null) {
            return  BaseResult.fail(validator);
        } else
        //验证通过
        {
            tbUser.setUpdated(new Date());
            //新增用户
            if (tbUser.getId() == null) {
                //密码加密
                tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
                tbUser.setCreated(new Date());
                userDao.save(tbUser);
            } else {
                //更新用户
                userDao.update(tbUser);
            }
            return BaseResult.success("保存用户成功");
        }

    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    public void update(TbUser tbUser) {

        userDao.update(tbUser);
    }

    @Override
    public TbUser findById(Long id) {
        return userDao.findById(id);
    }




    @Override
    public void deleteMulti(String[] ids) {
            userDao.deleteMulti(ids);
    }

    @Override
    public PageInfo<TbUser> page(int start, int draw, int length, TbUser  tbUser) {
        int count=userDao.count(tbUser);
        Map<String,Object> params=  new HashMap<>();
        params.put("start",start);
        params.put("tbUser",tbUser);
        params.put("length",length);
        PageInfo<TbUser> pageInfo=  new PageInfo();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(11);
        pageInfo.setRecordsFiltered(11);
        pageInfo.setData(userDao.page(params));
        return pageInfo;
    }

    @Override
    public int count(TbUser tbUser) {
        return userDao.count(tbUser);
    }


}
