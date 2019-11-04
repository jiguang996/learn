package com.jiguang.ssm.dao;

import com.jiguang.ssm.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {
    @Select("select *  from permission  where  id in (select permissionId from role_permission where roleId=#{id}")
    Permission findPermissionByRoleId(String id);

    @Delete("delete from role_permission where permissionId=#{id}")
    void deleteFromRole_Permission(String id) throws Exception;

    @Delete("delete from permission  where id=#{id}")
    void deleteById(String id);

    @Select("select * from permission where id= #{id} ")
    Permission findById(String id);

    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission);

    @Select("select * from permission")
    List<Permission> findAll();
}
