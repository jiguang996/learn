package com.jiguang.myshop.web.admin.service.impl;

import com.jiguang.myshop.commons.dto.BaseResult;
import com.jiguang.myshop.commons.dto.PageInfo;
import com.jiguang.myshop.commons.utils.RegexpUtils;
import com.jiguang.myshop.domain.TbContent;
import com.jiguang.myshop.domain.TbContentCategory;
import com.jiguang.myshop.domain.TbUser;
import com.jiguang.myshop.web.admin.dao.TbContentCategoryDao;
import com.jiguang.myshop.web.admin.dao.TbContentDao;
import com.jiguang.myshop.web.admin.service.TbContentCategoryService;
import com.jiguang.myshop.web.admin.service.TbContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ji
 * @Date 2019/10/20 16:23
 * @Version 1.0
 */
@Service
public class TbContentServiceImpl implements TbContentService {
    @Autowired
    private TbContentDao tbContentDao;


    @Override
    public List<TbContent> findAll() {
        return tbContentDao.findAll();
    }

    @Override
    public BaseResult save(TbContent tbContent) {
        BaseResult baseResult=checkTbContent(tbContent);
        //验证通过
        if(baseResult.getStatus()==BaseResult.STATUS_SUCCESS){
            tbContent.setUpdated(new Date());
            //新增用户
            if (tbContent.getId()==null){
                tbContent.setCreated(new Date());
                tbContentDao.save(tbContent);

            }
            else {
                //更新用户
                tbContentDao.update(tbContent);
            }
            baseResult.setMessage("保存内容信息成功");
        }
        return baseResult;

    }

    @Override
    public void delete(Long id) {
        tbContentDao.delete(id);
    }

    @Override
    public TbContent findById(Long id) {
        return tbContentDao.findById(id);
    }

    @Override
    public void deleteMulti(String[] ids) {
        tbContentDao.deleteMulti(ids);
    }

    @Override
    public void update(TbContent tbContent) {
        tbContentDao.update(tbContent);
    }


    @Override
    public PageInfo<TbContent> page(int start, int draw, int length, TbContent tbContent) {
            int count=tbContentDao.count(tbContent);

            Map<String,Object> params=  new HashMap<>();
            params.put("start",start);
            params.put("tbContent",tbContent);
            params.put("length",length);
            PageInfo<TbContent> pageInfo=  new PageInfo();
            pageInfo.setDraw(draw);
            pageInfo.setRecordsTotal(count);
            pageInfo.setRecordsFiltered(count);
            pageInfo.setData(tbContentDao.page(params));
            return pageInfo;
        }



    @Override
    public int count(TbContent tbContent) {
        return tbContentDao.count(tbContent);
    }


    private BaseResult checkTbContent(TbContent tbContent){
        BaseResult baseResult=BaseResult.success();
        //非空验证
        if(StringUtils.isBlank(tbContent.getCategoryId())){
            baseResult=BaseResult.fail("CategoryId不能为空");
        }else if(StringUtils.isBlank(tbContent.getContent())){
            baseResult=BaseResult.fail("CategoryId不能为空");
        } else if(tbContent.getId()==null){
            baseResult=BaseResult.fail("Id不能为空");
        }else if(StringUtils.isBlank(tbContent.getPic())){
            baseResult=BaseResult.fail("CPic不能为空");
        } else if(StringUtils.isBlank(tbContent.getPic2())){
            baseResult=BaseResult.fail("Pic2不能为空");
        } else if(StringUtils.isBlank(tbContent.getSubTitle())){
            baseResult=BaseResult.fail("SubTitle不能为空");
        }else if(StringUtils.isBlank(tbContent.getTitle())){
            baseResult=BaseResult.fail("Title不能为空");
        } else if(StringUtils.isBlank(tbContent.getTitleDesc())){
            baseResult=BaseResult.fail("TitleDesc不能为空");
        }   else if(StringUtils.isBlank(tbContent.getUrl())){
            baseResult=BaseResult.fail("Url不能为空");
        }
        return  baseResult;
    }
}
