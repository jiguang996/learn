package com.jiguang.myshopplus.business.feign;

import com.jiguang.myshopplus.business.feign.dto.IconParam;
import com.jiguang.myshopplus.business.feign.dto.PasswordParam;
import com.jiguang.myshopplus.business.feign.dto.ProfileParam;
import com.jiguang.myshopplus.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * 个人信息管理
 * <p>
 * Description:
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 * @date 2019-07-31 00:47:14
 */
@FeignClient(value = "business-profile", path = "profile",configuration = FeignRequestConfiguration.class )
public interface ProfileFeign {
    @GetMapping(value = "info/{username}")
    String info(@PathVariable String username);


    /**
     * 更新个人信息
     *
     * @param profileParam {@link ProfileParam}
     * @return {@code String} JSON
     */
    @PostMapping(value = "update")
    String update(@RequestBody ProfileParam profileParam);

    /**
     * 修改密码
     * @param passwordParam
     * @return
     */
    @PostMapping(value = "modify/password")
    String modifyPassword(@RequestBody PasswordParam passwordParam);

    /**
     * 修改头像
     * @param iconParam
     * @return
     */
    @PostMapping(value = "modify/icon")
    String modifyIcon(@RequestBody IconParam iconParam);
}
