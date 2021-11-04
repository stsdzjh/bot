package com.fourany.botauth.mappers;

import com.fourany.botauth.entities.SysRolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysRolePermissionMapper {
    @Select("select * from sys_role_permission where role_id=#{roleId}")
    public List<SysRolePermission> querySysRolePermissionByRoleId(String roleId);
}
