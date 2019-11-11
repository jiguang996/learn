package com.jiguang.ssm.dao;

import com.jiguang.ssm.domain.Permission;
import com.jiguang.ssm.domain.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRoleDao {
    @Select("select * from role where id in (select roleId from users_role  where userId=#{userId})" )
    List<Role> findRoleByUserId(String userId);
    @Select("select * from role")
    List<Role> findAll();
    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);
    @Select("select * from role where id=#{id}")
    Role findById(String id);

    @Select("delete from role where id=#{id}")
    void deleteRole(String id);

    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPermissionToRole(String permissionId, String roleId);

    @Select("select * from permission  where id not in ( select permissionId  from role_permission where roleId=#{roleId}")
    List<Permission> findOtherPermissions(String roleId);
}
