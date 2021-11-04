package com.fourany.botauth.mappers;

import com.fourany.botauth.entities.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysUserRoleMapper {

    @Select("select * from sys_user_role where uid=#{userid}")
    List<SysUserRole> querySysUserRoleByUserId(String userid);

    @Select("select * from sys_user_role where uid=#{userid}")
    SysUserRole getSysUserRoleByUserId(String userid);
}
