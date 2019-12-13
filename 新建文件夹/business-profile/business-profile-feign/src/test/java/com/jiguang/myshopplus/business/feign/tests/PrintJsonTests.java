package com.jiguang.myshopplus.business.feign.tests;

import com.jiguang.myshopplus.business.feign.dto.IconParam;
import com.jiguang.myshopplus.business.feign.dto.PasswordParam;
import com.jiguang.myshopplus.business.feign.dto.ProfileParam;
import com.jiguang.myshopplus.commons.utils.MapperUtils;
import org.junit.Test;


public class PrintJsonTests {

    @Test
    public void testPrintProfileParam() throws Exception {
        System.out.println(MapperUtils.obj2json(new ProfileParam()));
    }

    @Test
    public void testPrintIconParam() throws Exception {
        System.out.println(MapperUtils.obj2json(new IconParam()));
    }
    @Test
    public void testPrintPasswordParam() throws Exception {
        System.out.println(MapperUtils.obj2json(new PasswordParam()));
    }

}
